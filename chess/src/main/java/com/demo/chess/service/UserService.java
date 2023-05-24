package com.demo.chess.service;

import com.demo.chess.domain.Role;
import com.demo.chess.domain.User;
import com.demo.chess.dto.CredentialDto;
import com.demo.chess.dto.UserCreateDto;
import com.demo.chess.dto.UserRatingDto;
import com.demo.chess.dto.UserResponseDto;
import com.demo.chess.exception.EntityDuplicationException;
import com.demo.chess.exception.UserByIdNotFoundException;
import com.demo.chess.mapper.UserCreateMapper;
import com.demo.chess.mapper.UserMapper;
import com.demo.chess.repository.UserRepository;
import com.demo.chess.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserCreateMapper userCreateMapper;

    public String validateLogin(CredentialDto credentialDto) {
       User user =  readByNickname(credentialDto.getNickname());
       if(!user.getPassword().equals(credentialDto.getPassword())) {
           throw new BadCredentialsException("Invalid credentials!");
       }
       return JWTUtil.generateToken(user.getNickname());
    }
    public User getByIdOrThrow(long id){
        return userRepository.findById(id).orElseThrow(
                () -> new UserByIdNotFoundException("User with a specified ID not found!"));
    }

    public UserResponseDto getById(long id){

        return userMapper.toResponseDto(getByIdOrThrow(id));
    }


    public User readByNickname(String nickname){

        return userRepository.readByNickname(nickname);
    }

    public UserResponseDto create(UserCreateDto userCreateDto, String ip){

        Role role = getByIdOrThrow(1L).getRole();

        try {
            return userMapper.toResponseDto(userRepository.save(userCreateMapper.toUser(userCreateDto, ip, role)));
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityDuplicationException("User with the specified nickname already exists!");
        }

    }
    public void editUserRating(Long id, UserRatingDto userRatingDto) {
        User user = getByIdOrThrow(id);

        user.setCasualRating(userRatingDto.getCasualRating());
        user.setRankedRating(userRatingDto.getRankedRating());

        userRepository.save(user);
    }


}
