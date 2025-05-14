package com.board.game.controller.requestDto;

import com.board.game.model.Player;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerRequestDto {
    private String name;
    private String email;

    public PlayerRequestDto(final Player player) {
        this.name = player.getName();
        this.email = player.getEmail();
    }
}
