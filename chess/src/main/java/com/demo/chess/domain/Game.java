package com.demo.chess.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User playerWhite;

    @ManyToOne
    private User playerBlack;

    @Column(nullable = false, columnDefinition = "DECIMAL(13, 4)")
    private BigDecimal whiteRating;

    @Column(nullable = false, columnDefinition = "DECIMAL(13, 4)")
    private BigDecimal blackRating;

    @Column(nullable = false)
    private long timeTotal;

    @Column(nullable = false)
    private int timeIncrement;


    @Column(nullable = false)
    private boolean ranked;

    @Column(nullable = false)
    private String history;

    @Enumerated(EnumType.STRING)
    private Result result;

    @Enumerated(EnumType.STRING)
    private TerminationCause terminationCause;

    @Column(nullable = false)
    private LocalDateTime creationTime;

}
