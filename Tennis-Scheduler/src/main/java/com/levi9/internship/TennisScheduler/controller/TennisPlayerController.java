package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.service.TennisPlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tennis/tennis-player")
public class TennisPlayerController {

    private TennisPlayerService playerService;

    public TennisPlayerController(TennisPlayerService tennisPlayerService)
    {
        playerService=tennisPlayerService;
    }

    @ApiOperation("Get tennis player by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getTennisPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getTennisPlayer(id));
    }

    @ApiOperation("Get all tennis players")
    @GetMapping
    public ResponseEntity<?> getTennisPlayers() {
        return ResponseEntity.ok(playerService.getAllTennisPlayers());
    }

    
}
