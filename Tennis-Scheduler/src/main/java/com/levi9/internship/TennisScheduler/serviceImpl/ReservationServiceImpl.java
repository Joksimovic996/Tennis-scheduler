package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.mapper.reservation.CreateReservationMapper;
import com.levi9.internship.TennisScheduler.mapper.reservation.ReservationMapper;
import com.levi9.internship.TennisScheduler.mapper.timeSlot.CreateTimeSlotMapper;
import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.CreateReservationDTO;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import com.levi9.internship.TennisScheduler.repository.ReservationRepository;
import com.levi9.internship.TennisScheduler.repository.TennisCourtRepository;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import com.levi9.internship.TennisScheduler.repository.TimeSlotRepository;
import com.levi9.internship.TennisScheduler.service.ReservationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final CreateReservationMapper createReservationMapper;
    private final TennisPlayerRepository tennisPlayerRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final CreateTimeSlotMapper timeSlotMapper;
    private final TennisCourtRepository tennisCourtRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, CreateReservationMapper createReservationMapper, TennisPlayerRepository tennisPlayerRepository, TimeSlotRepository timeSlotRepository, CreateTimeSlotMapper timeSlotMapper, TennisCourtRepository tennisCourtRepository){
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.createReservationMapper = createReservationMapper;
        this.tennisPlayerRepository = tennisPlayerRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotMapper = timeSlotMapper;
        this.tennisCourtRepository = tennisCourtRepository;
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
    public void addReservation(CreateReservationDTO reservation, Long tennisPlayerId) {
        Reservation newReservation = new Reservation();
        TennisPlayer tennisPlayer = tennisPlayerRepository.getById(tennisPlayerId);
        List<TimeSlot> tempSlots = new ArrayList<>();
        Double price = 0.0;
        newReservation = createReservationMapper.map(reservation);

        List<TimeSlot> slotsInBase = new ArrayList<>();
        Boolean doNotReserve = false;
        for(CreateTimeSlotDTO timeSlotDTO : reservation.getTimeSlots()) {

            slotsInBase = timeSlotRepository.getTimeSlotOfSameDateAndCourt(timeSlotDTO.getStartDateAndTime(), timeSlotDTO.getEndDateAndTime(), timeSlotDTO.getTennisCourt());

            if (slotsInBase.isEmpty()){
                TimeSlot temp = timeSlotMapper.map(timeSlotDTO);
                temp.setReservation(newReservation);
                TennisCourt tennisCourt = tennisCourtRepository.getById(timeSlotDTO.getTennisCourt());
                temp.setTennisCourt(tennisCourt);
                tempSlots.add(temp);
                int minutesToPlay = (temp.getEndDateAndTime().getHour() * 60 + temp.getEndDateAndTime().getMinute()) - (temp.getStartDateAndTime().getHour() * 60 + temp.getStartDateAndTime().getMinute());
                price += minutesToPlay * temp.getTennisCourt().getPricePerMinute();
            } else {
                doNotReserve = true;
                System.out.println("POKLAPANJE: " + timeSlotDTO.getStartDateAndTime().toString() +" "+timeSlotDTO.getEndDateAndTime().toString());
            }


        }

        if(tempSlots.size() >= 5 ){
            price += 10;
        }

        newReservation.setReservationDate(LocalDateTime.now());
        newReservation.setPrice(price);
        newReservation.setTennisPlayer(tennisPlayer);

        if(!doNotReserve) {
            reservationRepository.save(newReservation);
        }else {
            System.out.println("NE ME ZE!");
        }
        for(TimeSlot temp : tempSlots) {
            timeSlotRepository.save(temp);
        }
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
