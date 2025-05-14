package com.board.game.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class PlayerMatches {

    @Id
    @Column(name="idt_player_matches")
    @GeneratedValue(generator = "id_player_matches_sequence")
    @SequenceGenerator(name = "id_player_matches_sequence", sequenceName = "id_player_matches_sequence", allocationSize = 1)
    private Long playerMatchesId;

    @ManyToOne
    @JoinColumn(name = "idt_player")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "idt_match")
    private Matches match;

    @Column(name="num_total_points")
    private int totalPoints;

    public PlayerMatches(Player player, Matches matches, int totalPoints) {
        this.player = player;
        this.match = matches;
        this.totalPoints = totalPoints;
    }
}
