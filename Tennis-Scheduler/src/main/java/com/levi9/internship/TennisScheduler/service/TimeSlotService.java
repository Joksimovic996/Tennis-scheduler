package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TimeSlot;

import java.util.List;

public interface TimeSlotService {

    public TimeSlot getTimeSlot(Long id);
    public List<TimeSlot> getAllTimeSlots();
    public TimeSlot addTimeSlot(TimeSlot timeSlot);
    public TimeSlot updateTimeSlot(TimeSlot timeSlot);
    public void deleteTimeSlotById(Long id);
}
