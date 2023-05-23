package com.demo.chess.service;

import com.demo.chess.domain.Affiliation;
import com.demo.chess.domain.Lobby;
import com.demo.chess.domain.User;
import com.demo.chess.dto.LobbyCreateDto;
import com.demo.chess.dto.LobbyResponseDto;
import com.demo.chess.exception.LobbyByIdNotFoundException;
import com.demo.chess.mapper.LobbyCreateMapper;
import com.demo.chess.mapper.LobbyMapper;
import com.demo.chess.mapper.LobbyMapperImpl;
import com.demo.chess.repository.LobbyRepository;
import com.demo.chess.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = {LobbyMapperImpl.class})
public class LobbyServiceTest {

    @Mock
    private LobbyRepository lobbyRepository;

    @Spy
    private LobbyMapper lobbyMapper = Mappers.getMapper(LobbyMapper.class);

    @Spy
    private LobbyCreateMapper lobbyCreateMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private LobbyService lobbyService;

    @Test
    public void getAllLobbiesTest(){
        List<LobbyResponseDto> correctLobbies = lobbyMapper.toDtoList(lobbyRepository.findAll());
        List<LobbyResponseDto> testedLobbies = lobbyService.getAllLobbies();

        assertEquals(correctLobbies, testedLobbies);
    }


    @Test
    public void createLobbyTest(){
        LobbyCreateDto testLobbyCreateDto = new LobbyCreateDto();
        testLobbyCreateDto.setTimeTotal(90L);
        testLobbyCreateDto.setTimeIncrement(10);
        testLobbyCreateDto.setAffiliationDistribution(Affiliation.WHITE);
        testLobbyCreateDto.setCompetitive(true);

        User user = new User();
        user.setNickname("USERNAME");
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(lobbyRepository.save(any(Lobby.class))).thenAnswer(inv -> inv.getArgument(0));

        LobbyResponseDto resultLobbyResponseDto = lobbyService.createLobby(testLobbyCreateDto);

        assertEquals("USERNAME", resultLobbyResponseDto.getHost().getNickname());

        assertEquals(testLobbyCreateDto.getTimeTotal(), resultLobbyResponseDto.getTimeTotal());
        assertEquals(testLobbyCreateDto.getTimeIncrement(), resultLobbyResponseDto.getTimeIncrement());
        assertEquals(testLobbyCreateDto.getAffiliationDistribution(), resultLobbyResponseDto.getAffiliationDistribution());
        assertEquals(testLobbyCreateDto.isCompetitive(), resultLobbyResponseDto.isCompetitive());
    }

    @Test
    public void deleteByIdTest(){
        when(lobbyRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(LobbyByIdNotFoundException.class, () -> lobbyService.deleteLobby(1L));
    }
}
