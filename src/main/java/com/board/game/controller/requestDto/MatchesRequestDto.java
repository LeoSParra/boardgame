package com.board.game.controller.requestDto;

import com.board.game.model.Matches;
import com.board.game.model.PlayerMatches;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class MatchesRequestDto {
    private String gameName;
    private String initialDate;
    private String finalDate;
    private List<PlayerMatchesRequestDto> players;

    public MatchesRequestDto(final Matches matches) {
        this.gameName = gameName;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }
}
