package com.board.game;

import org.junit.jupiter.api.Test;

public class ServiceTests {

    @Test
    public void should() {
        Player player = new Player();
        player.setNome("Jogador 1");
        player.setTotalPontos(10);
        PlayerPosition playerPosition = new PlayerPosition();
        playerPosition.setName(player.getNome());
        playerPosition.setTotalPoints(player.getTotalPontos());
        playerPosition.setPosition(1);
        playerPosition.showResults();
    }
}
