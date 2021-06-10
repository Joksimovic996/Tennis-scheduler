package com.levi9.internship.TennisScheduler.repository;

import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {


    @Query("select s from TimeSlot s where(s.reservation.id = :reservationId)")
    public List<TimeSlot> getTimeSlotsOfReservation(Long reservationId);
}
