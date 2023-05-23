package com.demo.chess.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.demo.chess.domain.Role;
import com.demo.chess.domain.User;
import com.demo.chess.dto.CredentialDto;
import com.demo.chess.dto.UserCreateDto;
import com.demo.chess.dto.UserResponseDto;
import com.demo.chess.exception.UserByIdNotFoundException;
import com.demo.chess.mapper.UserCreateMapper;
import com.demo.chess.mapper.UserMapper;
import com.demo.chess.mapper.UserMapperImpl;
import com.demo.chess.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserMapperImpl.class})
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Spy
    private UserCreateMapper userCreateMapper;

    @InjectMocks
    private UserService userService;


    @Test
    public void loginTest(){

        User user = new User();
        user.setNickname("test_nickname");
        user.setPassword("password");

        when(userRepository.readByNickname("test_nickname")).thenReturn(user);

        CredentialDto credentialDto = new CredentialDto();
        credentialDto.setNickname("test_nickname");
        credentialDto.setPassword("password");

        String token = userService.validateLogin(credentialDto);
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("secret".getBytes()))
                .build().verify(token);

        assertEquals(decodedJWT.getSubject(), user.getNickname());

        credentialDto.setPassword("password_incorrect");
        assertThrows(BadCredentialsException.class, () -> userService.validateLogin(credentialDto));

    }

    @Test
    public void createTest(){

        User user = new User();
        user.setNickname("test_nickname");
        user.setPassword("password");

        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_NAME");

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        UserCreateDto createDto = new UserCreateDto();
        createDto.setNickname("Nickname");
        createDto.setPassword("Password");

        when(userRepository.save(any(User.class))).thenAnswer(inv -> inv.getArgument(0));

        UserResponseDto responseDto = userService.create(createDto, "194.44.162.88");

        assertEquals("Nickname", responseDto.getNickname());

        when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(UserByIdNotFoundException.class, () -> userService.create(createDto, "194.44.162.88"));


    }

}
