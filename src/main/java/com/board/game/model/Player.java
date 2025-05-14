package com.board.game.model;

import com.board.game.controller.requestDto.PlayerRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "player")
public class Player {

    @Id
    @Column(name = "idt_player")
    @GeneratedValue(generator = "id_player_sequence")
    @SequenceGenerator(name = "id_player_sequence", sequenceName = "id_player_sequence", allocationSize = 1)
    private Long playerId;

    @Column(name = "des_name")
    private String name;

    @Column(name = "des_email")
    private String email;

    public Player (final PlayerRequestDto playerRequestDto) {
        this.name = playerRequestDto.getName();
        this.email = playerRequestDto.getEmail();
    }
}
