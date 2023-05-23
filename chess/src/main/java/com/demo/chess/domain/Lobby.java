package com.demo.chess.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "lobbies")
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Lobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User host;

    @Column(nullable = false, columnDefinition = "DECIMAL(13, 4)")
    private BigDecimal hostCasualRating;

    @Column(nullable = false, columnDefinition = "DECIMAL(13, 4)")
    private BigDecimal hostRankedRating;

    @Column(nullable = false)
    private long timeTotal;

    @Column(nullable = false)
    private int timeIncrement;

    @Enumerated(EnumType.STRING)
    private Affiliation affiliationDistribution;

    @Column(nullable = false)
    private boolean competitive;

    @Column(nullable = false)
    private LocalDateTime creationTime;

}
