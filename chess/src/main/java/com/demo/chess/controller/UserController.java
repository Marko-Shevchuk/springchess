package com.demo.chess.controller;

import com.demo.chess.dto.UserCreateDto;
import com.demo.chess.dto.UserRatingDto;
import com.demo.chess.dto.UserResponseDto;
import com.demo.chess.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserCreateDto userCreateDto, HttpServletRequest httpRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userCreateDto, httpRequest.getRemoteAddr()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> read(@PathVariable long id){
        return ResponseEntity.ok(userService.getById(id));
    }
    @PostMapping("/{id}/rerank")
    public ResponseEntity<Void> editUserRating(@PathVariable("id") Long id, @RequestBody UserRatingDto userRatingDto) {
        userService.editUserRating(id, userRatingDto);
        return ResponseEntity.ok().build();
    }

}
