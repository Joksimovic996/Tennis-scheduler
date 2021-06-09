package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.CreateReservationDTO;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;

import java.util.List;

public interface ReservationService {

    public ReservationDTO getReservation(Long id);
    public List<ReservationDTO> getAllReservations();
    public void addReservation(CreateReservationDTO reservation, Long tennisPlayerId);
    public Boolean updateReservation(CreateReservationDTO reservation,Long id);
    public void deleteReservationById(Long id);
}
