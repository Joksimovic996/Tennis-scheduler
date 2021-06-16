package com.levi9.internship.tennisscheduler.repository;

import com.levi9.internship.tennisscheduler.model.TennisPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayer,Long> {

    @Query("select tp from TennisPlayer tp where (lower(tp.email)  = lower(:email) and tp.deleted = false)")
    TennisPlayer getTennisPlayerByEmail(@Param("email") String email);

    @Query("select tp from TennisPlayer tp where (tp.username = :username and tp.deleted = false)")
    TennisPlayer findByUsername(String username);

    @Query("select tp from TennisPlayer tp where (tp.id = :playerId and tp.deleted = false)")
    TennisPlayer getTennisPlayerById(@Param("playerId") Long id);

    @Query("select tp from TennisPlayer tp where (tp.deleted = false)")
    List<TennisPlayer> getAllPlayers();

}
