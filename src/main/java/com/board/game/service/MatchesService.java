package com.board.game.service;

import com.board.game.controller.requestDto.EmailRequestDto;
import com.board.game.controller.requestDto.MatchesRequestDto;
import com.board.game.controller.requestDto.PlayerMatchesRequestDto;
import com.board.game.exceptions.GameNotFoundException;
import com.board.game.model.Game;
import com.board.game.model.Matches;
import com.board.game.model.Player;
import com.board.game.model.PlayerMatches;
import com.board.game.producers.EmailProducer;
import com.board.game.repository.GameRepository;
import com.board.game.repository.MatchesRepository;
import com.board.game.repository.PlayerMatchesRepository;
import com.board.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesService {

    @Autowired
    private MatchesRepository matchesRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlayerMatchesRepository playerMatchesRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EmailProducer emailProducer;

    public Matches save(final MatchesRequestDto matchesRequestDto) {
        Game game = this.gameRepository.findByName(matchesRequestDto.getGameName());
        Matches matches = new Matches(matchesRequestDto);
        matches.setGame(game);
        matchesRepository.save(matches);

        for(PlayerMatchesRequestDto playerMatchesRequestDto : matchesRequestDto.getPlayers()) {
            Player player = playerRepository.findByName(playerMatchesRequestDto.getPlayerName());

            PlayerMatches playerMatches = new PlayerMatches(player, matches, playerMatchesRequestDto.getTotalPoints());
            playerMatchesRepository.save(playerMatches);
        }

        List<PlayerMatches> playerMatchesList = playerMatchesRepository.findByMatch(matches);

        sendMatchResultsEmailsAsync(playerMatchesList);

        return matches;
    }

    @Async
    public void sendMatchResultsEmailsAsync(List<PlayerMatches> playerMatchesList) {
        // ordernar os jogadores por pontuacao (do maior para o menor)
        playerMatchesList.sort((p1, p2) -> Integer.compare(p2.getTotalPoints(), p1.getTotalPoints()));

        StringBuilder emailBody = new StringBuilder("Resultado da partida:\n\n");
        int rank = 1;
        for (PlayerMatches playerMatch : playerMatchesList) {
            emailBody.append(rank++)
                    .append(". ")
                    .append(playerMatch.getPlayer().getName())
                    .append(" - ")
                    .append(playerMatch.getTotalPoints())
                    .append(" pontos\n");
        }

        for (PlayerMatches playerMatch : playerMatchesList) {
            EmailRequestDto emailRequestDto = new EmailRequestDto();
            emailRequestDto.setTo(playerMatch.getPlayer().getEmail());
            emailRequestDto.setSubject("Resultado da partida");
            emailRequestDto.setBody(emailBody.toString());

            emailProducer.sendEmailToQueue(emailRequestDto);
        }
    }
}
