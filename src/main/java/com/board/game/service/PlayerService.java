package com.board.game.service;

import com.board.game.model.Player;
import com.board.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player save(final Player player) {
        return this.playerRepository.save(player);
    }
}
