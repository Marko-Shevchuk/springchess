package com.demo.chess.mapper;

import com.demo.chess.domain.Game;
import com.demo.chess.dto.GameResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {

    GameResponseDto toResponseDto(Game game);

    List<GameResponseDto> toDtoList(List<Game> games);
}