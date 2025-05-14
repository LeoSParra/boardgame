package com.board.game.controller.requestDto;


import com.board.game.model.Matches;
import com.board.game.model.PlayerMatches;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerMatchesRequestDto {
    public String playerName;
    public int totalPoints;
}
