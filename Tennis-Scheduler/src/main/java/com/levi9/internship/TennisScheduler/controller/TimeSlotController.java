package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import com.levi9.internship.TennisScheduler.serviceImpl.TimeSlotServiceImpl;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<?> addTimeSlot(@RequestBody CreateTimeSlotDTO timeSlotDTO){
        timeSlotService.addTimeSlot(timeSlotDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTimeSlot(@RequestBody CreateTimeSlotDTO timeSlot, @PathVariable Long id){
        return ResponseEntity.ok(timeSlotService.updateTimeSlot(timeSlot, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTimeSlot(@PathVariable Long id){
        timeSlotService.deleteTimeSlotById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
