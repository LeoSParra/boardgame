package com.board.game.controller;

import com.board.game.controller.requestDto.MatchesRequestDto;
import com.board.game.controller.responseDto.MatchesResponseDto;
import com.board.game.model.Matches;
import com.board.game.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("matches")
public class MatchesController {

    @Autowired
    private MatchesService matchesService;

    @PostMapping
    public MatchesResponseDto saveMatches(@RequestBody final MatchesRequestDto matchesRequestDto) {
        Matches matches = matchesService.save(matchesRequestDto);
        return new MatchesResponseDto(matches);
    }
}
