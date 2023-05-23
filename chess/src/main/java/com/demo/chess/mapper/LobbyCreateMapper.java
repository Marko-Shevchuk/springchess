package com.demo.chess.mapper;

import com.demo.chess.domain.Lobby;
import com.demo.chess.domain.User;
import com.demo.chess.dto.LobbyCreateDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LobbyCreateMapper {



    public Lobby toLobby(LobbyCreateDto lobby, User user){

        return Lobby.builder()
                .host(user)
                .hostCasualRating(user.getCasualRating())
                .hostRankedRating(user.getRankedRating())
                .timeTotal(lobby.getTimeTotal())
                .timeIncrement(lobby.getTimeIncrement())
                .affiliationDistribution(lobby.getAffiliationDistribution())
                .competitive(lobby.isCompetitive())
                .creationTime(LocalDateTime.now())
                .build();
    }
}