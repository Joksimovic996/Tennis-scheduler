package com.levi9.internship.tennisscheduler.serviceimpl;

import com.levi9.internship.tennisscheduler.mapper.timeslot.TimeSlotMapper;
import com.levi9.internship.tennisscheduler.modeldto.timeslot.TimeSlotDTO;
import com.levi9.internship.tennisscheduler.repository.TimeSlotRepository;
import com.levi9.internship.tennisscheduler.service.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final TimeSlotMapper timeSlotMapper;


    public TimeSlotServiceImpl(TimeSlotRepository timeSlotRepository, TimeSlotMapper timeSlotMapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotMapper = timeSlotMapper;
    }

    @Override
    public TimeSlotDTO getTimeSlot(Long id) {
        return timeSlotMapper.map(timeSlotRepository.getById(id));
    }

    @Override
    public List<TimeSlotDTO> getAllTimeSlots() {
        List<TimeSlotDTO> timeSlots = new ArrayList<>();
        timeSlotRepository.findAll().forEach(timeSlot -> timeSlots.add(timeSlotMapper.map(timeSlot)));
        return timeSlots;

    }

}
