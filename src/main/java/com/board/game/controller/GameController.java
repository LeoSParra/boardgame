package com.board.game.controller;

import com.board.game.controller.requestDto.GameRequestDto;
import com.board.game.controller.responseDto.GameResponseDto;
import com.board.game.model.Game;
import com.board.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public GameResponseDto saveGame(@RequestBody final GameRequestDto gameRequestDto) {
        Game game = new Game(gameRequestDto);
        game = this.gameService.save(game);
        return new GameResponseDto(game);
    }

    @PostMapping("/search")
    public GameResponseDto searchAndSaveGame(@RequestParam String search) {
        Game game = this.gameService.searchAndSaveGame(search);
        return new GameResponseDto(game);
    }

}
