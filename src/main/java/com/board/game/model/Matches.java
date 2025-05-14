package com.board.game.model;


import com.board.game.controller.requestDto.MatchesRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "matches")
public class Matches {

    @Id
    @Column(name = "idt_match")
    @GeneratedValue(generator = "id_matches_sequence")
    @SequenceGenerator(name = "id_matches_sequence", sequenceName = "id_matches_sequence", allocationSize = 1)
    private Long matchesId;

    @ManyToOne
    @JoinColumn(name="idt_game")                                         // Foreign key
    private Game game;

    @Column(name="des_initial_date")
    private String initialDate;

    @Column(name="des_final_date")
    private String finalDate;

    @ManyToMany
    @JoinTable(
            name = "player_matches",
            joinColumns = @JoinColumn(name = "idt_match"),
            inverseJoinColumns = @JoinColumn(name = "idt_player")
    )
    private List<Player> players = new ArrayList<>();

    public Matches (final MatchesRequestDto matchesRequestDto) {
        this.initialDate = matchesRequestDto.getInitialDate();
        this.finalDate = matchesRequestDto.getFinalDate();
    }
}
