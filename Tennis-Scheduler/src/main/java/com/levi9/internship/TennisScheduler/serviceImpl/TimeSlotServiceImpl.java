package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.exceptions.TennisException;
import com.levi9.internship.TennisScheduler.mapper.timeSlot.CreateTimeSlotMapper;
import com.levi9.internship.TennisScheduler.mapper.timeSlot.TimeSlotMapper;
import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;
import com.levi9.internship.TennisScheduler.repository.ReservationRepository;
import com.levi9.internship.TennisScheduler.repository.TennisCourtRepository;
import com.levi9.internship.TennisScheduler.repository.TimeSlotRepository;
import com.levi9.internship.TennisScheduler.service.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final TimeSlotMapper timeSlotMapper;
    private final CreateTimeSlotMapper createTimeSlotMapper;
    private final TennisCourtRepository tennisCourtRepository;
    private final ReservationRepository reservationRepository;


    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, TimeSlotMapper timeSlotMapper, CreateTimeSlotMapper createTimeSlotMapper, TennisCourtRepository tennisCourtRepository, ReservationRepository reservationRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotMapper = timeSlotMapper;
        this.createTimeSlotMapper = createTimeSlotMapper;
        this.tennisCourtRepository = tennisCourtRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public TimeSlotDTO getTimeSlot(Long id) {
        try {
            return timeSlotMapper.map(timeSlotRepository.getById(id));
        } catch (Exception e) {
            throw new TennisException(HttpStatus.NOT_FOUND, "GET METHOD: Time slot with that ID does not exist!");
        }

    }

    @Override
    public List<TimeSlotDTO> getAllTimeSlots() {
        List<TimeSlotDTO> timeSlots = new ArrayList<>();
        timeSlotRepository.findAll().forEach(timeSlot -> {
            timeSlots.add(timeSlotMapper.map(timeSlot));
        });
        return timeSlots;

    }

    @Override
    public void addTimeSlot(CreateTimeSlotDTO timeSlot, Long reservationId, Long courtId) {
        TimeSlot newTimeSlot = new TimeSlot();
        Reservation reservation = reservationRepository.getById(reservationId);
        TennisCourt tennisCourt = tennisCourtRepository.getById(courtId);
        newTimeSlot = createTimeSlotMapper.map(timeSlot);
        newTimeSlot.setReservation(reservation);
        newTimeSlot.setTennisCourt(tennisCourt);
        timeSlotRepository.save(newTimeSlot);
    }

    @Override
    public Boolean updateTimeSlot(CreateTimeSlotDTO timeSlot, Long id) {
        TimeSlot tmp = timeSlotRepository.getById(id);
        if (tmp != null) {
            timeSlotRepository.save(createTimeSlotMapper.map(timeSlot));
        }
        return null;
    }

    @Override
    public void deleteTimeSlotById(Long id) {
        timeSlotRepository.deleteById(id);
    }
}
