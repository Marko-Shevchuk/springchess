package com.demo.chess.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class UserResponseDto {
    private long id;
    @NotBlank
    private String nickname;
    @NotBlank
    private LocalDateTime lastLogin;
    @NotBlank
    private BigDecimal casualRating;
    @NotBlank
    private BigDecimal rankedRating;

}
