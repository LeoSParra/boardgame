package com.board.game.controller.responseDto;

import com.board.game.model.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerResponseDto {
    private String name;
    private String email;

    public PlayerResponseDto(final Player player) {
        this.name = player.getName();
        this.email = player.getEmail();
    }
}
