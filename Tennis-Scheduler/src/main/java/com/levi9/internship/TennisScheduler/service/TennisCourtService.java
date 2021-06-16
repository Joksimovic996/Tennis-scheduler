package com.levi9.internship.tennisscheduler.service;

import com.levi9.internship.tennisscheduler.modeldto.tenniscourt.CreateTennisCourtDTO;
import com.levi9.internship.tennisscheduler.modeldto.tenniscourt.TennisCourtDTO;
import com.levi9.internship.tennisscheduler.modeldto.tenniscourt.UpdateTennisCourtDTO;
import com.levi9.internship.tennisscheduler.modeldto.timeslot.TimeSlotDTO;

import java.util.List;

public interface TennisCourtService {

    void addTennisCourt(CreateTennisCourtDTO tennisCourtDTO);
    TennisCourtDTO getTennisCourtById(Long id);
    TennisCourtDTO getTennisCourtByName(String name);
    List<TennisCourtDTO> getAllCourts();
    void updateTennisCourt(UpdateTennisCourtDTO tennisCourtDTO, Long id);
    void deleteTennisCourt(Long id);
    List<TimeSlotDTO> getTimeSlotsByTennisCourt(Long id);


}
