package com.board.game;

import com.board.game.exceptions.MillestonesInputedDataException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class GameApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void shouldThrowMillestonesInputedDataExceptionWhenMillestonesExcedLimit() {
		// given - dado
		Service service = new Service();
		List<Player> players = new ArrayList<>();

		Player player1 = new Player();
		player1.setMarcos(2);
		players.add(player1);

		Player player2 = new Player();
		player2.setMarcos(2);
		players.add(player2);

		// when
		assertThrows(MillestonesInputedDataException.class, () -> {
			service.validateMillestonesAndAwards(players);
		});
	}
}
