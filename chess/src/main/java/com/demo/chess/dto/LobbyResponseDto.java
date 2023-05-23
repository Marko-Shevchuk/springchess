package com.demo.chess.dto;

import com.demo.chess.domain.Affiliation;
import com.demo.chess.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class LobbyResponseDto {
    @NotBlank
    private UserResponseDto host;
    @NotBlank
    private BigDecimal hostCasualRating;
    @NotBlank
    private BigDecimal hostRankedRating;
    @NotBlank
    private long timeTotal;
    @NotBlank
    private int timeIncrement;
    @NotBlank
    private Affiliation affiliationDistribution;
    @NotBlank
    private boolean competitive;
    @NotBlank
    private LocalDateTime creationTime;
}
