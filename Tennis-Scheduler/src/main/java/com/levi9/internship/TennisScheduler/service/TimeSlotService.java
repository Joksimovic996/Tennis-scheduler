package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;

import java.util.List;

public interface TimeSlotService {

    public TimeSlotDTO getTimeSlot(Long id);
    public List<TimeSlotDTO> getAllTimeSlots();
    public void addTimeSlot(CreateTimeSlotDTO timeSlotDTO);
    public Boolean updateTimeSlot(CreateTimeSlotDTO timeSlotDTO, Long id);
    public void deleteTimeSlotById(Long id);
}
