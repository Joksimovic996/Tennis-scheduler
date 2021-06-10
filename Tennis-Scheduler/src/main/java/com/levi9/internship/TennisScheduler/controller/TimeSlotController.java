package com.levi9.internship.TennisScheduler.controller;


import com.levi9.internship.TennisScheduler.serviceImpl.TimeSlotServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis/time-slot")
public class TimeSlotController {

    private final TimeSlotServiceImpl timeSlotService;

    public TimeSlotController(TimeSlotServiceImpl timeSlotService){
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTimeSlot(@PathVariable Long id){
        return ResponseEntity.ok(timeSlotService.getTimeSlot(id));
    }

    @GetMapping
    public ResponseEntity<?> getTimeSlots(){
        return ResponseEntity.ok(timeSlotService.getAllTimeSlots());
    }

}
