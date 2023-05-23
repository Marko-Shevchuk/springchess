package com.demo.chess.controller;

import com.demo.chess.dto.LobbyCreateDto;
import com.demo.chess.dto.LobbyResponseDto;
import com.demo.chess.service.LobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lobbies")
@RequiredArgsConstructor
public class LobbyController {

    private final LobbyService lobbyService;

    @PostMapping("/")
    public ResponseEntity<LobbyResponseDto> createLobby(@RequestBody LobbyCreateDto lobbyCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(lobbyService.createLobby(lobbyCreateDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<LobbyResponseDto>> getAllLobbies() {
        List<LobbyResponseDto> lobbies = lobbyService.getAllLobbies();
        return ResponseEntity.ok(lobbies);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLobby(@PathVariable("id") Long id) {
        lobbyService.deleteLobby(id);
        return ResponseEntity.ok("Lobby deleted successfully");
    }
    @GetMapping("/find")
    public ResponseEntity<List<LobbyResponseDto>> getAllFilteredLobbies(
            @RequestParam(value = "timeTotalMin", required = false) Long timeTotalMin,
            @RequestParam(value = "timeTotalMax", required = false) Long timeTotalMax,
            @RequestParam(value = "timeIncrementMin", required = false) Integer timeIncrementMin,
            @RequestParam(value = "timeIncrementMax", required = false) Integer timeIncrementMax,
            @RequestParam(value = "competitive", required = true) boolean competitive
    ) {
        List<LobbyResponseDto> lobbies = lobbyService.getAllFilteredLobbies(timeTotalMin, timeTotalMax, timeIncrementMin, timeIncrementMax, competitive);
        return ResponseEntity.ok(lobbies);
    }


}
