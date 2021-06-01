package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.repository.TimeSlotRepository;
import com.levi9.internship.TennisScheduler.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository){
        this.timeSlotRepository = timeSlotRepository;
    }

    @Override
    public TimeSlot getTimeSlot(Long id) {

        TimeSlot timeSlot = timeSlotRepository.getById(id);

        if (timeSlot != null) { return timeSlot; }

        return null;
    }

    @Override
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    @Override
    public TimeSlot addTimeSlot(TimeSlot timeSlot) {
        return null;
    }

    @Override
    public TimeSlot updateTimeSlot(TimeSlot timeSlot) {
        return null;
    }

    @Override
    public void deleteTimeSlotById(Long id) {

    }
}
