package com.board.game.model;

import com.board.game.controller.requestDto.GameRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "game")
public class Game {

    @Id
    @Column(name="idt_game")
    @GeneratedValue(generator = "id_game_sequence")
    @SequenceGenerator(name = "id_game_sequence", sequenceName = "id_game_sequence", allocationSize = 1)
    private Long gameId;

    @Column(name="des_name")
    private String name;

    @Column(name="num_peso")
    private int peso;

    @Column(name="des_type")
    private String type;

    @Column(name="num_min_players")
    private int minPlayers;

    @Column(name="num_max_players")
    private int maxPlayers;

    @Column(name="des_name_artist")
    private String artistName;

    @Column(name="des_name_design")
    private String designName;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Matches> matches;

    public Game(final GameRequestDto gameRequestDto) {
        this.name = gameRequestDto.getName();
        this.peso = gameRequestDto.getPeso();
        this.type = gameRequestDto.getType();
        this.minPlayers = gameRequestDto.getMinPlayers();
        this.maxPlayers = gameRequestDto.getMaxPlayers();
    }

}
