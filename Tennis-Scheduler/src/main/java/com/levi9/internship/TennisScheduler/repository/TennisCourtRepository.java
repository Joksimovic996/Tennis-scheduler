package com.levi9.internship.tennisscheduler.repository;

import com.levi9.internship.tennisscheduler.model.TennisCourt;
import com.levi9.internship.tennisscheduler.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TennisCourtRepository extends JpaRepository<TennisCourt, Long> {


    Optional<TennisCourt> findById(Long id);

    @Query("select t from TennisCourt  t where (lower(t.name)  = lower(:courtName))")
    TennisCourt getTennisCourtByName(@Param("courtName") String name);

    @Query("select s from TimeSlot s where(s.tennisCourt.id = :courtId)")
    List<TimeSlot> getTimeSlotsOfTennisCourt(@Param("courtId") Long id);
}
