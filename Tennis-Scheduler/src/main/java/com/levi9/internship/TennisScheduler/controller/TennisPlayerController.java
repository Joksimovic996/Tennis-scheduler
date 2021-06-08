package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.CreateTennisPlayerDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.TennisPlayerDTO;
import com.levi9.internship.TennisScheduler.service.TennisPlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "List Of Tennis Player Endpoints")
@RequestMapping("/tennis/tennis-player")
public class TennisPlayerController {

    private TennisPlayerService playerService;

    public TennisPlayerController(TennisPlayerService tennisPlayerService)
    {
        playerService=tennisPlayerService;
    }


    @GetMapping("/{id}")
    @ApiOperation(
            value = "Finds Tennis Player By ID",
            notes = "Provide an ID to look up specific tennis player",
            response = TennisPlayerDTO.class
    )
    public ResponseEntity<?> getTennisPlayer(
            @ApiParam(
                    value = "ID value for the player you need to retrieve",
                    required = true
            )
            @PathVariable Long id) {
        return ResponseEntity.ok(playerService.getTennisPlayer(id));
    }

    @GetMapping()
    @ApiOperation(
            value = "Finds a List Of All Tennis Players In The System",
            response = List.class
    )
    public ResponseEntity<?> getTennisPlayers() {

        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @PostMapping()
    @ApiOperation(
            value = "Adds a New Tennis Player",
            notes = "Requires an instance of CreateTennisPlayerDTO"
    )
    public ResponseEntity<?> addTennisPlayer(@RequestBody CreateTennisPlayerDTO tennisPlayerDTO) {
        playerService.addTennisPlayer(tennisPlayerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Updates The Existing Tennis Player",
            notes = "Requires an instance of CreateTennisPlayerDTO and ID of the tennis player"
    )
    public ResponseEntity<?> updateTennisPlayer(@RequestBody CreateTennisPlayerDTO tennisPlayerDTO, @PathVariable Long id) {
        return ResponseEntity.ok(playerService.updateTennisPlayer(tennisPlayerDTO, id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes The Existing Tennis Player",
            notes = "Requires an ID of the tennis player"
    )
    public ResponseEntity<?> deleteTennisPlayer(
            @ApiParam(
                    value = "ID of the Tennis Player",
                    required = true
            )
            @PathVariable Long id) {
        playerService.deleteTennisPlayer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByEmail")
    @ApiOperation(
            value = "Finds Tennis Player By Email",
            notes = "Provide player's email address to look up specific tennis player",
            response = TennisPlayerDTO.class
    )
    public ResponseEntity<?> getTennisPlayerByEmail(
            @ApiParam(
                    value = "Email value from the player you need to retrieve",
                    required = true
            )
            @RequestParam(value = "email") String email) {
        return ResponseEntity.ok(playerService.getTennisPlayerByEmail(email));
    }
}
