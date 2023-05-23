package com.demo.chess.dto;

import com.demo.chess.domain.Result;
import com.demo.chess.domain.TerminationCause;
import com.demo.chess.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class GameResponseDto {
    private long id;

    @NotBlank
    private UserResponseDto playerWhite;

    @NotBlank
    private UserResponseDto playerBlack;

    @NotBlank
    private BigDecimal whiteRating;

    @NotBlank
    private BigDecimal blackRating;

    @NotBlank
    private long timeTotal;

    @NotBlank
    private int timeIncrement;

    @NotNull
    private boolean competitive;

    @NotNull
    private String history;

    @NotNull
    private Result result;

    @NotNull
    private TerminationCause terminationCause;

    @NotNull
    private LocalDateTime creationTime;
}
