package com.board.game.controller.responseDto;

import com.board.game.model.Matches;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatchesResponseDto {
    private String gameName;
    private String initialDate;
    private String finalDate;

    public MatchesResponseDto(final Matches matches) {
        this.gameName = gameName;
        this.initialDate = matches.getInitialDate();
        this.finalDate = matches.getFinalDate();
    }

}
