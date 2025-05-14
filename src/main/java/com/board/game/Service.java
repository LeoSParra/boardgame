package com.board.game;

import com.board.game.exceptions.AwardsInputedDataException;
import com.board.game.exceptions.MillestonesInputedDataException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Service {

    public List<PlayerPosition> calculatePositions(List<Player> players) {

        List<PlayerPosition> playerPositions = new ArrayList<PlayerPosition>();

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            player.setTotalPontos(player.sumPoints());

        }

        players.sort(Comparator.comparing(Player::getTotalPontos).reversed());

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            PlayerPosition playerPosition = new PlayerPosition();
            playerPosition.setName(player.getNome());
            playerPosition.setTotalPoints(player.getTotalPontos());
            playerPosition.setPosition(i + 1);

            playerPositions.add(playerPosition);

        }

        return playerPositions;
    }

    public void validateMillestonesAndAwards(List<Player> players) {
        int millestonesSum = 0;
        int awardsSum = 0;

        for (Player player : players) {
            millestonesSum = millestonesSum + player.getMarcos();
            awardsSum = awardsSum + player.getPremiosPrimeiro();
        }

        if (millestonesSum > 3 || millestonesSum < 0){
            //return false;
            throw new MillestonesInputedDataException();
        }
        if (awardsSum > 3l || awardsSum < 0){
            //return false;
            throw new AwardsInputedDataException();
        }
    }

    public List<Player> inputMillestonesAndAwards(List<Player> players) {
        Scanner scanner = new Scanner(System.in);

        for (Player player : players) {
            System.out.println("Digite o número de prêmios de primeiro lugar do jogador " + player.getNome() + ":");
            player.setPremiosPrimeiro(scanner.nextInt());

            System.out.println("Digite o número de prêmios de segundo lugar do jogador " + player.getNome() + ":");
            player.setPremiosSegundo(scanner.nextInt());

            System.out.println("Digite o número de marcos do jogador: " + player.getNome() + ":");
            player.setMarcos(scanner.nextInt());
        }
        tratamento(players);
        return players;
    }

    public List<Player> tratamento(List<Player> players) {
        Scanner scanner = new Scanner(System.in);
        boolean awardsValidate = false;
        boolean millestonesValidate = false;

        while (!awardsValidate || !millestonesValidate) {
            try {
                validateMillestonesAndAwards(players);
                awardsValidate = true;
                millestonesValidate = true;

            } catch (MillestonesInputedDataException e) {
                System.out.println("Quantidade de marcos inválida, digite novamente: ");

                for (Player player : players) {
                    System.out.println("Digite o número de marcos do jogador " + player.getNome() + ":");
                    player.setMarcos(scanner.nextInt());

                }

            } catch (AwardsInputedDataException e) {
                System.out.println("Quantidade de prêmios inválida, digite novamente: ");

                for (Player player : players) {
                    System.out.println("Digite o número de prêmios de primeiro lugar do jogador " + player.getNome() + ":");
                    player.setPremiosPrimeiro(scanner.nextInt());

                    System.out.println("Digite o número de prêmios de segundo lugar do jogador " + player.getNome() + ":");
                    player.setPremiosSegundo(scanner.nextInt());
                }
            }
        }
        return players;
    }
}
