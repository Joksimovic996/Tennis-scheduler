package com.levi9.internship.TennisScheduler.serviceImpl;

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

        TimeSlot timeSlot = timeSlotRepository.getById(id);

        if (timeSlot != null) {
            return timeSlotMapper.map(timeSlot);
        }

        return null;
    }

    @Override
    public List<TimeSlotDTO> getAllTimeSlots() {
        List<TimeSlotDTO> timeSlots = new ArrayList<>();
        timeSlotRepository.findAll().forEach(timeSlot -> timeSlots.add(timeSlotMapper.map(timeSlot)));
        return timeSlots;

    }

    @Override
    public void addTimeSlot(CreateTimeSlotDTO timeSlot) {
        TimeSlot newTimeSlot = new TimeSlot();
        TennisCourt tennisCourt = tennisCourtRepository.getById(timeSlot.getTennisCourtId());
        Reservation reservation = reservationRepository.getById(timeSlot.getReservationId());
        newTimeSlot = createTimeSlotMapper.map(timeSlot);
        newTimeSlot.setTennisCourtId(tennisCourt);
        newTimeSlot.setReservationId(reservation);
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
