package com.board.game.controller;

import com.board.game.controller.requestDto.PlayerRequestDto;
import com.board.game.controller.responseDto.PlayerResponseDto;
import com.board.game.model.Player;
import com.board.game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public PlayerResponseDto savePlayer(@RequestBody final PlayerRequestDto playerRequestDto) {
        Player player = new Player(playerRequestDto);
        player = this.playerService.save(player);
        return new PlayerResponseDto(player);
    }
}
