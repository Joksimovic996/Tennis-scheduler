package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;

import java.util.List;

public interface TimeSlotService {

    public TimeSlotDTO getTimeSlot(Long id);
    public List<TimeSlotDTO> getAllTimeSlots();

}
