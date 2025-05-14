package com.board.game;

import com.board.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class GameApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(GameApplication.class, args);

//		Scanner scanner = new Scanner(System.in);
//		Service service = new Service();
//		ArrayList<Player> players = new ArrayList<Player>();
//
//		boolean inputValidate = false;
//		int numeroJogadores = 0;
//
//		while (numeroJogadores < 2 || numeroJogadores > 5) {
//			System.out.println("Digite o numero de jogadores (2 a 5): ");
//			numeroJogadores = scanner.nextInt();
//
//			if (numeroJogadores < 2 || numeroJogadores > 5) {
//				System.out.println("Numero de jogadores inválido");
//			}
//			else {
//				for (int i = 0; i < numeroJogadores; i++) {
//					Player player = new Player();
//
//					System.out.println("Digite o nome do jogador: ");
//					player.setNome(scanner.next());
//
//					System.out.println("Digite o numero de arvores do jogador " + player.getNome());
//					player.setArvores(scanner.nextInt());
//
//					System.out.println("Digite o numero de cidades do jogador " + player.getNome());
//					player.setCidades(scanner.nextInt());
//
//					System.out.println("Digite o numero de terraformacoes do jogador " + player.getNome());
//					player.setTerraformacao(scanner.nextInt());
//
//					System.out.println("Digite a quantidade de pontos de cartas do jogador: " + player.getNome());
//					player.setCartas(scanner.nextInt());
//
//					players.add(player);
//				}
//			}
//		}
//
//		service.inputMillestonesAndAwards(players);
//
//		service.validateMillestonesAndAwards(players);
//
//		List<PlayerPosition> PlayerPositionsList = service.calculatePositions(players);
//
//		for (PlayerPosition playerPosition : PlayerPositionsList) {
//			playerPosition.showResults();
//		}

//		GameService gameService = context.getBean(GameService.class);
//		gameService.init();

	}
}
