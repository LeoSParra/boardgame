package com.board.game.repository;

import com.board.game.model.Matches;
import com.board.game.model.PlayerMatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerMatchesRepository extends JpaRepository<PlayerMatches, Long> {
    List<PlayerMatches> findAll();

    PlayerMatches save(PlayerMatches playerMatches);

    PlayerMatches findByPlayerMatchesId(Long playerMatchesId);

    List<PlayerMatches> findByMatch(Matches match);
}
