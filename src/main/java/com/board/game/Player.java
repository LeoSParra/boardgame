package com.board.game;

public class Player {
    private int arvores;
    private int cidades;
    private int terraformacao;
    private int premiosPrimeiro;
    private int premiosSegundo;
    private int marcos;
    private int cartas;
    private String nome;
    private int totalPontos;


    public int getArvores() {
        return arvores;
    }

    public int getCartas() {
        return cartas;
    }

    public int getCidades() {
        return cidades;
    }

    public int getTerraformacao() {
        return terraformacao;
    }

    public int getPremiosPrimeiro() {
        return premiosPrimeiro;
    }

    public int getPremiosSegundo() {
        return premiosSegundo;
    }

    public int getMarcos() {
        return marcos;
    }

    public String getNome() {
        return nome;
    }

    public int getTotalPontos() {
        return totalPontos;
    }

    public void setArvores(int arvores) {
        this.arvores = arvores;
    }

    public void setCidades(int cidades) {
        this.cidades = cidades;
    }

    public void setTerraformacao(int terraformacao) {
        this.terraformacao = terraformacao;
    }

    public void setPremiosPrimeiro(int premiosPrimeiro) {
        this.premiosPrimeiro = premiosPrimeiro;
    }

    public void setPremiosSegundo(int premiosSegundo) {
        this.premiosSegundo = premiosSegundo;
    }

    public void setMarcos(int marcos) {
        this.marcos = marcos;
    }

    public void setCartas(int cartas) {
        this.cartas = cartas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTotalPontos(int totalPontos) {
        this.totalPontos = totalPontos;
    }

    public Player(int arvores, int cidades, int terraformacao, int premiosPrimeiro, int premiosSegundo, int marcos, int cartas, String nome) {
        this.arvores = arvores;
        this.cidades = cidades;
        this.terraformacao = terraformacao;
        this.premiosPrimeiro = premiosPrimeiro;
        this.premiosSegundo = premiosSegundo;
        this.marcos = marcos;
        this.cartas = cartas;
        this.nome = nome;
    }

    public Player () {

    }

    public int calculateMillestones() {
        return this.marcos * 5;
    }

    public int calculateAwardsFirstPosition() {
        return this.premiosPrimeiro * 5;
    }

    public int calculateAwardsSecondPosition() {
        return this.premiosSegundo * 2;
    }

    public int sumPoints() {
        return this.arvores + this.cidades + this.terraformacao + this.calculateMillestones()
                + this.calculateAwardsFirstPosition() + this.calculateAwardsSecondPosition()
                + this.cartas;
    }


}