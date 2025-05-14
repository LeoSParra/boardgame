package com.board.game.controller.requestDto;

import com.board.game.model.Game;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GameRequestDto {

    private String name;
    private int peso;
    private String type;
    private int minPlayers;
    private int maxPlayers;
    private String artistName;
    private String designName;

    public GameRequestDto(final Game game) {
        this.name = game.getName();
        this.peso = game.getPeso();
        this.type = game.getType();
        this.minPlayers = game.getMinPlayers();
        this.maxPlayers = game.getMaxPlayers();
        this.artistName = game.getArtistName();
        this.designName = game.getDesignName();
    }

}
