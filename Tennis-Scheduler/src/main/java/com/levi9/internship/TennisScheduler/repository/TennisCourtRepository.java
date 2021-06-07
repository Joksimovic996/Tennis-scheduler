package com.levi9.internship.TennisScheduler.repository;

import com.levi9.internship.TennisScheduler.model.TennisCourt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TennisCourtRepository extends JpaRepository<TennisCourt, Long> {


    public Optional<TennisCourt> findById(Long id);

    @Query("select t from TennisCourt  t where (lower(t.name)  = lower(:courtName))")
    public TennisCourt getTennisCourtByName(@Param("courtName") String name);
}
