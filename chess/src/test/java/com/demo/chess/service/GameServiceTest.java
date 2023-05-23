package com.demo.chess.service;


import com.demo.chess.domain.Game;
import com.demo.chess.dto.GameResponseDto;
import com.demo.chess.exception.GameByIdNotFoundException;
import com.demo.chess.mapper.GameMapper;
import com.demo.chess.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    @Spy
    private GameMapper mapper = Mappers.getMapper(GameMapper.class);


    @Test
    public void readByIdOrThrowTest(){

        Game game = new Game();
        when(gameRepository.findById(anyLong())).thenReturn(Optional.of(game));

        assertEquals(game, gameService.getByIdOrThrow(1L));

    }


    @Test
    public void  getAllGamesTest(){

        List<Game> list = LongStream.range(0, 10).mapToObj(i -> {
            Game game = new Game();
            game.setId(i);
            return game;
        }).toList();

        when(gameRepository.findAll()).thenReturn(list);
        List<GameResponseDto> games = gameService.getAllGames();

        assertEquals(list.size(), games.size());

    }


    @Test
    public void deleteTest(){
        when(gameRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(GameByIdNotFoundException.class, () -> gameService.deleteGame(1L));
    }

}
