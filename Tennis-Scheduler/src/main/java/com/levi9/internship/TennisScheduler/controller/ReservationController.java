package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.modelDTO.reservation.CreateReservationDTO;
import com.levi9.internship.TennisScheduler.serviceImpl.ReservationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> addReservation(@RequestParam(name = "tennisPlayerId") Long tennisPlayerId,
                                            @Valid @RequestBody CreateReservationDTO reservation){
        reservationService.addReservation(reservation, tennisPlayerId);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@RequestBody CreateReservationDTO reservation, @PathVariable Long id){
        return ResponseEntity.ok(reservationService.updateReservation(reservation, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservationById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
