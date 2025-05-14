package com.board.game.repository;

import com.board.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAll();

    Game save(Game game);

    Game findByGameId(Long gameId);

    Game findByName(String name);
}
