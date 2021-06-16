package com.levi9.internship.tennisscheduler.repository;

import com.levi9.internship.tennisscheduler.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {



}
