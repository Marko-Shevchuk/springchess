package com.demo.chess.dto;

import com.demo.chess.domain.Affiliation;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LobbyFindDto {

    @NotBlank
    private long timeTotalMin;
    @NotBlank
    private long timeTotalMax;
    @NotBlank
    private int timeIncrementMin;
    @NotBlank
    private int timeIncrementMax;
    @NotBlank
    private boolean competitive;


}
