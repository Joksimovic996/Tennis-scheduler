package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.exceptions.TennisException;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        return reservationMapper.map(reservationRepository.getById(id));
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> tempReservations = new ArrayList<>();
        List<ReservationDTO> reservations = new ArrayList<>();
        tempReservations = reservationRepository.findAll();
        for (Reservation temp : tempReservations) {
            reservations.add(reservationMapper.map(temp));
        }
        return reservations;

    }

    @Override
    public void addReservation(CreateReservationDTO reservation, Long tennisPlayerId) {

        Reservation newReservation = new Reservation();
        newReservation = createReservationMapper.map(reservation);
        List<TimeSlot> slotsToBeSaved = new ArrayList<>();
        List<TimeSlot> slotsInBase = new ArrayList<>();
        double price = 0.0;
        TennisPlayer tennisPlayer = tennisPlayerRepository.getById(tennisPlayerId);

        List<TimeSlot> alreadyHasTimeSlotsOnThatDay = new ArrayList<>();

        for(CreateTimeSlotDTO timeSlotDTO : reservation.getTimeSlots()) {

            LocalDate startDate = timeSlotDTO.getStartDateAndTime().toLocalDate();
            LocalDateTime startDateMidnight = LocalDateTime.of(startDate, LocalTime.MIDNIGHT);
            LocalDateTime dayAfterMidnight = startDateMidnight.plusDays(1).toLocalDate().atStartOfDay();

            alreadyHasTimeSlotsOnThatDay = timeSlotRepository.getTimeSlotsOfTennisPlayerForGivenDate(tennisPlayerId, startDateMidnight, dayAfterMidnight);
            if(!alreadyHasTimeSlotsOnThatDay.isEmpty())
                throw new TennisException(HttpStatus.BAD_REQUEST, "You cannot reserve two timeslots same day!");


            slotsInBase = timeSlotRepository.getTimeSlotOfSameDateAndCourt(timeSlotDTO.getStartDateAndTime(), timeSlotDTO.getEndDateAndTime(), timeSlotDTO.getTennisCourt());
            if (slotsInBase.isEmpty()){
                TennisCourt tennisCourt = tennisCourtRepository.getById(timeSlotDTO.getTennisCourt());
                TimeSlot timeSlot = setCurrentTimeSlot(timeSlotDTO, newReservation, tennisCourt);
                slotsToBeSaved.add(timeSlot);
                price += getPriceOfTimeSlot(timeSlot);
            } else {
                throw new TennisException(HttpStatus.BAD_REQUEST, "You cannot have overlapping with timeslots!");
            }


        }
        //additional fee for more than five slots
        price = slotsToBeSaved.size() > 5 ? price + 10 : price;

        newReservation.setReservationDate(LocalDateTime.now());
        newReservation.setPrice(price);
        newReservation.setTennisPlayer(tennisPlayer);

        reservationRepository.save(newReservation);
        for(TimeSlot temp : slotsToBeSaved) {
            timeSlotRepository.save(temp);
        }
    }

    @Override
    public void updateReservation(CreateReservationDTO reservation, Long id) {
        Reservation temp = reservationRepository.getById(id);
        reservationRepository.save(createReservationMapper.map(reservation));

    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    private Double getPriceOfTimeSlot(TimeSlot timeSlot) {
        return ((timeSlot.getEndDateAndTime().getHour() * 60 + timeSlot.getEndDateAndTime().getMinute())
                - (timeSlot.getStartDateAndTime().getHour() * 60 + timeSlot.getStartDateAndTime().getMinute())) *
                timeSlot.getTennisCourt().getPricePerMinute();
    }

    private TimeSlot setCurrentTimeSlot(CreateTimeSlotDTO createTimeSlotDTO, Reservation newReservation, TennisCourt tennisCourt) {
        TimeSlot timeSlot = timeSlotMapper.map(createTimeSlotDTO);
        timeSlot.setReservation(newReservation);
        timeSlot.setTennisCourt(tennisCourt);
        return timeSlot;
    }
}
