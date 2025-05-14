package com.board.game.service;

import com.board.game.PlayerPosition;
import com.board.game.model.Game;
import com.board.game.model.Matches;
import com.board.game.model.Player;
import com.board.game.repository.GameRepository;
import com.board.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private RestTemplate restTemplate; // necessario para realizar chamadas http

    private final String BASE_URL = "https://ludopedia.com.br/api/v1/jogos";

    public Game save(final Game game) {
        return this.gameRepository.save(game);
    }

    public Game searchAndSaveGame(final String search) {
        String accessToken = "6f0ef8d0f98ee6f2e27d58aa3e32c986";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        // 1. Buscar jogos na Ludopedia com autenticacao
        String searchUrl = BASE_URL + "?search=" + search;
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                searchUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {}
        );

        List<Map<String, Object>> jogos = (List<Map<String, Object>>) response.getBody().get("jogos");

        if (jogos == null || jogos.isEmpty()) {
            throw new RuntimeException("Nenhum jogo encontrado com o nome: " + search);
        }

        // 2. Procurar o jogo com nome exato
        Map<String, Object> matchedGame = jogos.stream()
                .filter(jogo -> search.equalsIgnoreCase((String) jogo.get("nm_jogo")))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Jogo com o nome exato não encontrado."));

        Integer idJogo = (Integer) matchedGame.get("id_jogo");

        // 3. Obter detalhes do jogo
        String detailsUrl = BASE_URL + "/" + idJogo;
        ResponseEntity<Map<String, Object>> detailsResponse = restTemplate.exchange(
                detailsUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<>() {}
        );

        Map<String, Object> jogoDetalhes = detailsResponse.getBody();

        if (jogoDetalhes == null) {
            throw new RuntimeException("Não foi possível obter os detalhes do jogo com ID: " + idJogo);
        }

        // 4. Converter os detalhes em uma entidade Game
        Game game = new Game();
        game.setName((String) jogoDetalhes.get("nm_jogo"));
        game.setPeso((Integer) jogoDetalhes.getOrDefault("vl_tempo_jogo", 0));
        game.setType((String) jogoDetalhes.get("tp_jogo"));
        game.setMinPlayers((Integer) jogoDetalhes.getOrDefault("qt_jogadores_min", 0));
        game.setMaxPlayers((Integer) jogoDetalhes.getOrDefault("qt_jogadores_max", 0));

        // 5. Salvar no banco de dados
        return gameRepository.save(game);
    }
}
