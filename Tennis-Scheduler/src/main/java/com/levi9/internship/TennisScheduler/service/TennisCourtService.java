package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;

import java.util.List;

public interface TennisCourtService {

    public void addTennisCourt(CreateTennisCourtDTO tennisCourtDTO);

    public TennisCourtDTO getTennisCourtById(Long id);

    public TennisCourtDTO getTennisCourtByName(String name);

    public List<TennisCourtDTO> getAllCourts();

    public Boolean updateTennisCourt(CreateTennisCourtDTO tennisCourtDTO, Long id);

    public void deleteTennisCourt(Long id);


}
