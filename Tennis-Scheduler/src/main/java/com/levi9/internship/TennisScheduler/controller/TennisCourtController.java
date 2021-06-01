package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.serviceImpl.TennisCourtServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<?> getTennisCourts() {
        return ResponseEntity.ok(courtService.getAllCourts());
    }
}
