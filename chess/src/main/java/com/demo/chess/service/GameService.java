package com.demo.chess.service;

import com.demo.chess.domain.Game;
import com.demo.chess.domain.User;
import com.demo.chess.dto.GameResponseDto;
import com.demo.chess.dto.UserResponseDto;
import com.demo.chess.exception.GameByIdNotFoundException;
import com.demo.chess.exception.UserByIdNotFoundException;
import com.demo.chess.mapper.GameMapper;
import com.demo.chess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public Game getByIdOrThrow(long id){
        return gameRepository.findById(id).orElseThrow(
                () -> new GameByIdNotFoundException("Game with the specified ID not found!"));
    }
    public GameResponseDto getById(long id){

        return gameMapper.toResponseDto(getByIdOrThrow(id));
    }
    public GameService(GameRepository gameRepository, GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    public List<GameResponseDto> getAllGames() {
        List<Game> games = gameRepository.findAll();
        return gameMapper.toDtoList(games);
    }
    public void deleteGame(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new GameByIdNotFoundException("Game with the specified ID not found!");
        }
        gameRepository.deleteById(id);
    }
}