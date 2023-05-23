package com.demo.chess.mapper;

import com.demo.chess.domain.Lobby;
import com.demo.chess.domain.Role;
import com.demo.chess.domain.User;
import com.demo.chess.dto.LobbyCreateDto;
import com.demo.chess.dto.UserCreateDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class UserCreateMapper {



    public User toUser(UserCreateDto userCreateDto, String ip, Role role){

        return new User()
                .toBuilder()
                .nickname(userCreateDto.getNickname())
                .password(userCreateDto.getPassword())
                .creatorIp(ip)
                .lastLogin(LocalDateTime.now())
                .creationTime(LocalDateTime.now())
                .role(role)
                .badScore((short)0)
                .casualRating(new BigDecimal(100))
                .rankedRating(new BigDecimal(100))
                .build();
    }
}