package com.demo.chess.repository;

import com.demo.chess.domain.Lobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LobbyRepository extends JpaRepository<Lobby, Long> {

    List<Lobby> findByTimeTotalBetweenAndTimeIncrementBetweenAndCompetitive(
            long minTime, long maxTime, int minInc, int maxInc, boolean competitive);


}