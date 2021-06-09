package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.mapper.reservation.CreateReservationMapper;
import com.levi9.internship.TennisScheduler.mapper.reservation.ReservationMapper;
import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.CreateReservationDTO;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;
import com.levi9.internship.TennisScheduler.repository.ReservationRepository;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import com.levi9.internship.TennisScheduler.service.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final CreateReservationMapper createReservationMapper;
    private final TennisPlayerRepository tennisPlayerRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, CreateReservationMapper createReservationMapper, TennisPlayerRepository tennisPlayerRepository){
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.createReservationMapper = createReservationMapper;
        this.tennisPlayerRepository = tennisPlayerRepository;
    }

    @Override
    public ReservationDTO getReservation(Long id) {
        Reservation reservation = reservationRepository.getById(id);

        if (reservation != null) { return reservationMapper.map(reservation); }

        return null;
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> tempReservations = new ArrayList<>();
        List<ReservationDTO> reservations = new ArrayList<>();
        tempReservations = reservationRepository.findAll();
        if (!tempReservations.isEmpty()) {
            for (Reservation temp : tempReservations) {
                reservations.add(reservationMapper.map(temp));
            }
            return reservations;
        }
        return null;
    }

    @Override
    public void addReservation(CreateReservationDTO reservation) {
        Reservation newReservation = new Reservation();
        newReservation = createReservationMapper.map(reservation);
        newReservation.setReservationDate(LocalDateTime.now());
        newReservation.setPrice(0.0);
        reservationRepository.save(newReservation);
    }

    @Override
    public Boolean updateReservation(CreateReservationDTO reservation, Long id) {
        Reservation temp = reservationRepository.getById(id);
        if ( temp != null )  {
            reservationRepository.save(createReservationMapper.map(reservation));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}
