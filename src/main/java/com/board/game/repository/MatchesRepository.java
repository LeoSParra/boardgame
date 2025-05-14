package com.board.game.repository;

import com.board.game.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchesRepository extends JpaRepository<Matches, Long> {

    List<Matches> findAll();

    Matches save(Matches matches);

    Matches findByMatchesId(Long matchesId);
}
