package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.Reservation;

import java.util.List;

public interface ReservationService {

    public Reservation getReservation(Long id);
    public List<Reservation> getAllReservations();
    public Reservation addReservation(Reservation reservation);
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservationById(Long id);
}
