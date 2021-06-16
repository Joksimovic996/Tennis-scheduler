package com.levi9.internship.tennisscheduler.service;

import com.levi9.internship.tennisscheduler.modeldto.creditcard.CreditCardDTO;
import com.levi9.internship.tennisscheduler.modeldto.reservation.CreateReservationDTO;
import com.levi9.internship.tennisscheduler.modeldto.reservation.ReservationDTO;

import java.util.List;

public interface ReservationService {

    ReservationDTO getReservation(Long id);
    List<ReservationDTO> getAllReservations();
    void addReservation(CreateReservationDTO reservation, Long tennisPlayerId, CreditCardDTO creditCardDTO);
    void updateReservation(Boolean paid,Long id);
    void deleteReservationById(Long id);
}
