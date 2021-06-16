package com.levi9.internship.tennisscheduler.service;

import com.levi9.internship.tennisscheduler.modeldto.timeslot.TimeSlotDTO;

import java.util.List;

public interface TimeSlotService {

    TimeSlotDTO getTimeSlot(Long id);
    List<TimeSlotDTO> getAllTimeSlots();

}
