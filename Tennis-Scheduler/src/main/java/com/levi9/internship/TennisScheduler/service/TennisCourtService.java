package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.exceptions.TennisException;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.UpdateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;

import java.util.List;

public interface TennisCourtService {

    public void addTennisCourt(CreateTennisCourtDTO tennisCourtDTO);

    public TennisCourtDTO getTennisCourtById(Long id);

    public TennisCourtDTO getTennisCourtByName(String name);

    public List<TennisCourtDTO> getAllCourts();

    public void updateTennisCourt(UpdateTennisCourtDTO tennisCourtDTO, Long id);

    public void deleteTennisCourt(Long id);

    public List<TimeSlotDTO> getTimeSlotsByTennisCourt(Long id);


}
