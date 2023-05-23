package com.demo.chess.dto;

import com.demo.chess.domain.Affiliation;
import com.demo.chess.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LobbyCreateDto {

    @NotBlank
    private long timeTotal;
    @NotBlank
    private int timeIncrement;
    @NotBlank
    private Affiliation affiliationDistribution;
    @NotBlank
    private boolean competitive;


}
