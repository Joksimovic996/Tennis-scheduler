package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.serviceImpl.ReservationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis/reservation")
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    public ReservationController(ReservationServiceImpl reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReservation(@PathVariable Long id){
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    @GetMapping
    public ResponseEntity<?> getReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @PostMapping
    public ResponseEntity<?> addReservation(@RequestBody Reservation r){
        return ResponseEntity.ok(reservationService.addReservation(r));
    }

    @PutMapping
    public ResponseEntity<?> updateReservation(@RequestBody Reservation r){
        return ResponseEntity.ok(reservationService.updateReservation(r));
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservationById(id);
    }
}
