package com.demo.chess.controller;

import com.demo.chess.dto.GameResponseDto;
import com.demo.chess.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("/")
    public ResponseEntity<List<GameResponseDto>> getAllGames() {
        List<GameResponseDto> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id") Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.ok("Game deleted successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<GameResponseDto> getGameById(@PathVariable("id") long gameId) {
            GameResponseDto gameResponseDto = gameService.getById(gameId);
            return ResponseEntity.ok(gameResponseDto);

    }
}