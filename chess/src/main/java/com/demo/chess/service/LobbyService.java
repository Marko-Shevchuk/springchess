package com.demo.chess.service;

import com.demo.chess.domain.Lobby;
import com.demo.chess.domain.User;
import com.demo.chess.dto.LobbyCreateDto;
import com.demo.chess.dto.LobbyResponseDto;
import com.demo.chess.exception.LobbyByIdNotFoundException;
import com.demo.chess.exception.UserByIdNotFoundException;
import com.demo.chess.mapper.LobbyCreateMapper;
import com.demo.chess.mapper.LobbyMapper;
import com.demo.chess.repository.LobbyRepository;
import com.demo.chess.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LobbyService {

    private final LobbyRepository lobbyRepository;
    private final UserRepository userRepository;
    private final LobbyMapper lobbyMapper;
    private final LobbyCreateMapper lobbyCreateMapper;


    public List<LobbyResponseDto> getAllLobbies() {
        return lobbyMapper.toDtoList(lobbyRepository.findAll());
    }
    public List<LobbyResponseDto> getAllFilteredLobbies(Long timeTotalMin, Long timeTotalMax, Integer timeIncrementMin, Integer timeIncrementMax, boolean competitive) {
        timeTotalMin = timeTotalMin != null ? timeTotalMin : 0;
        timeTotalMax = timeTotalMax != null ? timeTotalMax : Long.MAX_VALUE;
        timeIncrementMin = timeIncrementMin != null ? timeIncrementMin : 0;
        timeIncrementMax = timeIncrementMax != null ? timeIncrementMax : Integer.MAX_VALUE;
        return lobbyMapper.toDtoList(lobbyRepository.findByTimeTotalBetweenAndTimeIncrementBetweenAndCompetitive(timeTotalMin, timeTotalMax, timeIncrementMin, timeIncrementMax, competitive));
    }


//    public UserDetails readByNickname(String nickname){
//        return userRepository.readByNickname(nickname);
//    }

    public LobbyResponseDto createLobby(LobbyCreateDto lobbyCreateDto){

        User testUser = userRepository.findById(1L).orElseThrow(
                () -> new UserByIdNotFoundException("User with a specified ID not found!")); //todo: get real post sender


        Lobby lobby = lobbyCreateMapper.toLobby(lobbyCreateDto, testUser);

        return lobbyMapper.toDto(lobbyRepository.save(lobby));
    }
    public void deleteLobby(Long id) {
        if (!lobbyRepository.existsById(id)) {
            throw new LobbyByIdNotFoundException("Lobby with the specified ID not found!");
        }
        lobbyRepository.deleteById(id);
    }

}
