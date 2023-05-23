package com.demo.chess.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class UserDto {
    private long id;
    @NotBlank
    private String nickname;
    @NotBlank
    private long roleId;
    @NotBlank
    private String creatorIp;
    @NotBlank
    private LocalDateTime creationTime;
    @NotBlank
    private LocalDateTime lastLogin;
    @NotBlank
    private BigDecimal casualRating;
    @NotBlank
    private BigDecimal rankedRating;
    @NotBlank
    private short badScore;
}