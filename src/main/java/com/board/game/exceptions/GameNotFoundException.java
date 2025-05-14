package com.board.game.exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(String gameName) {
        super("O jogo " + gameName + " nao existe.");
    }
}
