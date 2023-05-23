package com.demo.chess.mapper;

import com.demo.chess.domain.Lobby;
import com.demo.chess.dto.LobbyCreateDto;
import com.demo.chess.dto.LobbyResponseDto;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface LobbyMapper {

    LobbyResponseDto toDto(Lobby lobby);

    List<LobbyResponseDto> toDtoList(List<Lobby> lobbies);
    Lobby toEntity(LobbyCreateDto dto);
}
