package com.levi9.internship.TennisScheduler.controller;

import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.UpdateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.serviceImpl.TennisCourtServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "List Of Tennis Court Endpoints")
@RequestMapping("/tennis/tennis-court")
public class TennisCourtController {

    private final TennisCourtServiceImpl courtService;

    public TennisCourtController(TennisCourtServiceImpl courtService) {
        this.courtService = courtService;
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Finds Tennis Court By ID",
            notes = "Provide an ID to look up specific tennis court",
            response = TennisCourtDTO.class
    )
    public ResponseEntity<?> getTennisCourtById(
            @ApiParam(
                    value = "ID value for the court you need to retrieve",
                    required = true
            )
            @PathVariable Long id) {
        return ResponseEntity.ok(courtService.getTennisCourtById(id));
    }

    @GetMapping("/findByName")
    @ApiOperation(
            value = "Finds Tennis Court By Name",
            notes = "Provide name of court to look up specific tennis court",
            response = TennisCourtDTO.class
    )
    public ResponseEntity<?> getTennisCourtByName(
            @ApiParam(
                    value = "Name value for the court you need to retrieve",
                    required = true
            )
            @RequestParam(value = "name") String name) {
        return ResponseEntity.ok(courtService.getTennisCourtByName(name));
    }


    @GetMapping()
    @ApiOperation(
            value = "Finds a List Of All Tennis Courts In The System",
            response = List.class
    )
    public ResponseEntity<?> getTennisCourts() {
        return ResponseEntity.ok(courtService.getAllCourts());
    }

    @PostMapping()
    @ApiOperation(
            value = "Adds a New Tennis Court",
            notes = "Requires an instance of CreateTennisCourtDTO"
    )
    public ResponseEntity<?> addTennisCourt(
            @ApiParam(
                    value = "Instance of CreateTennisCourtDTO",
                    required = true
            )
            @RequestBody CreateTennisCourtDTO tennisCourtDTO) {
        courtService.addTennisCourt(tennisCourtDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(
            value = "Updates The Existing Tennis Court",
            notes = "Requires an instance of CreateTennisCourtDTO and ID of the tennis court"
    )
    public ResponseEntity<?> updateTennisCourt(@RequestBody UpdateTennisCourtDTO tennisCourtDTO, @PathVariable Long id) {
        courtService.updateTennisCourt(tennisCourtDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deletes The Existing Tennis Court",
            notes = "Requires an ID of the tennis court"
    )
    public ResponseEntity<?> deleteTennisCourt(
            @ApiParam(
                    value = "ID of the Tennis Court",
                    required = true
            )
            @PathVariable Long id) {
        courtService.deleteTennisCourt(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
