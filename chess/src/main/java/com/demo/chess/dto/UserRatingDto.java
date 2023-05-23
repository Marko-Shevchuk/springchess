package com.demo.chess.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserRatingDto {

    @NotBlank
    private BigDecimal casualRating;
    @NotBlank
    private BigDecimal rankedRating;

}
