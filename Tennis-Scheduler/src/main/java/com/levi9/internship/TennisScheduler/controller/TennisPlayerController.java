package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.CreateTennisPlayerDTO;
import com.levi9.internship.TennisScheduler.service.TennisPlayerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
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


    @GetMapping("/{id}")
    public ResponseEntity<?> getTennisPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getTennisPlayer(id));
    }

    @GetMapping()
    public ResponseEntity<?> getTennisPlayers() {

        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @PostMapping()
    public ResponseEntity<?> addTennisPlayer(@RequestBody CreateTennisPlayerDTO tennisPlayerDTO) {
        playerService.addTennisPlayer(tennisPlayerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTennisPlayer(@RequestBody CreateTennisPlayerDTO tennisPlayerDTO, @PathVariable Long id) {
        return ResponseEntity.ok(playerService.updateTennisPlayer(tennisPlayerDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTennisPlayer(@PathVariable Long id) {
        playerService.deleteTennisPlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
