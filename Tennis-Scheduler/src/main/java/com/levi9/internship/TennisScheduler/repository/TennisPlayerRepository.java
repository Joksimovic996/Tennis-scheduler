package com.levi9.internship.TennisScheduler.repository;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayer,Long> {

    @Query("select tp from TennisPlayer tp where (lower(tp.email)  = lower(:email))")
    public TennisPlayer getTennisPlayerByEmail(@Param("email") String email);
}
