package com.board.game.controller.responseDto;

import com.board.game.model.Game;
import com.board.game.model.Matches;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
public class GameResponseDto {

    private String name;
    private int peso;
    private String type;
    private int minPlayers;
    private int maxPlayers;
    private String artistName;
    private String designName;

    public GameResponseDto(final Game game) {
        this.name = game.getName();
        this.peso = game.getPeso();
        this.type = game.getType();
        this.minPlayers = game.getMinPlayers();
        this.maxPlayers = game.getMaxPlayers();
        this.artistName = game.getArtistName();
        this.designName = game.getDesignName();
    }
}
