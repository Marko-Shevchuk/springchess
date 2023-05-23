package com.demo.chess.controller;

import com.demo.chess.dto.CredentialDto;
import com.demo.chess.dto.JWTDto;
import com.demo.chess.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    @PostMapping("/login")
    public JWTDto login(@RequestBody CredentialDto credentialDto) {
        return new JWTDto(userService.validateLogin(credentialDto));
    }
}
