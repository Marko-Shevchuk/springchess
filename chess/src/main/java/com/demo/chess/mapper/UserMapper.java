package com.demo.chess.mapper;

import com.demo.chess.domain.User;
import com.demo.chess.dto.UserDto;
import com.demo.chess.dto.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserResponseDto toResponseDto(User user);
    UserDto toDto(User user);

}
