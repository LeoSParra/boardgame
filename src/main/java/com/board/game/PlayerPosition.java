package com.board.game;

public class PlayerPosition {
    private int position;
    private int totalPoints;
    private String name;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showResults() {
        System.out.println("\nPosicao: " + this.position);
        System.out.println("Nome: " + this.name);
        System.out.println("Pontos: " + this.totalPoints);
    }

}
