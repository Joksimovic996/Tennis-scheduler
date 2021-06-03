package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.serviceImpl.TennisCourtServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis/tennis-court")
public class TennisCourtController {

    private final TennisCourtServiceImpl courtService;

    public TennisCourtController(TennisCourtServiceImpl courtService) {
        this.courtService = courtService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTennisCourt(@PathVariable Long id) {
        return ResponseEntity.ok(courtService.getTennisCourt(id));
    }

    @GetMapping()
    public ResponseEntity<?> getTennisCourts() {
        return ResponseEntity.ok(courtService.getAllCourts());
    }

    @PostMapping()
    public ResponseEntity<?> addTennisCourt(@RequestBody CreateTennisCourtDTO tennisCourtDTO) {
        courtService.addTennisCourt(tennisCourtDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTennisCourt(@RequestBody CreateTennisCourtDTO tennisCourtDTO, @PathVariable Long id) {
        return ResponseEntity.ok(courtService.updateTennisCourt(tennisCourtDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTennisCourt(@PathVariable Long id) {
        courtService.deleteTennisCourt(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
