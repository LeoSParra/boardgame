package com.board.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void shouldHaveTwoMillestonesAndReturnTenPoints() {
        // given - dado
        Player player = new Player();
        player.setMarcos(2);

        // when - quando
        int millestonePoints = player.calculateMillestones();

        // then - então
        assertEquals(10, millestonePoints, "Pontos de marcos corretos");

    }

    @Test
    public void shouldHaveTenMillestonesAndReturnFifithPoints() {
        // given - dado
        Player player = new Player();
        player.setMarcos(10);

        // when - quando
        int millestonePoints = player.calculateMillestones();

        // then - então
        assertEquals(50, millestonePoints, "Pontos de marcos corretos");
    }
}
