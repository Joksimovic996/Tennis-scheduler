package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.controller.TennisCourtController;
import com.levi9.internship.TennisScheduler.mapper.tennisCourt.CreateTennisCourtMapper;
import com.levi9.internship.TennisScheduler.mapper.tennisCourt.TennisCourtMapper;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.repository.TennisCourtRepository;
import com.levi9.internship.TennisScheduler.service.TennisCourtService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TennisCourtServiceImpl implements TennisCourtService {

    private final TennisCourtRepository courtRepository;
    private final TennisCourtMapper tennisCourtMapper;
    private final CreateTennisCourtMapper createTennisCourtMapper;



    public TennisCourtServiceImpl(TennisCourtRepository courtRepository, TennisCourtMapper tennisCourtMapper, CreateTennisCourtMapper createTennisCourtMapper) {
        this.courtRepository = courtRepository;
        this.tennisCourtMapper = tennisCourtMapper;
        this.createTennisCourtMapper = createTennisCourtMapper;
    }

    @Override
    public void addTennisCourt(CreateTennisCourtDTO tennisCourtDTO) {
        TennisCourt newCourt = new TennisCourt();
        newCourt = createTennisCourtMapper.map(tennisCourtDTO);
        courtRepository.save(newCourt);
    }

    @Override
    public TennisCourtDTO getTennisCourt(Long id) {
        TennisCourt tennisCourt = courtRepository.getById(id);
        if (tennisCourt != null) {
            return tennisCourtMapper.map(tennisCourt);
        }
        return null;
    }

    @Override
    public List<TennisCourtDTO> getAllCourts() {
        List<TennisCourt> tempCourts = new ArrayList<>();
        List<TennisCourtDTO> tennisCourts = new ArrayList<>();
        tempCourts = courtRepository.findAll();
        if (!tempCourts.isEmpty()) {
            for (TennisCourt temp : tempCourts) {
                tennisCourts.add(tennisCourtMapper.map(temp));
            }
            return tennisCourts;
        }
        return null;

    }

    @Override
    public Boolean updateTennisCourt(CreateTennisCourtDTO tennisCourtDTO, Long id) {
        TennisCourt temp = courtRepository.getById(id);
        if ( temp != null )  {
            courtRepository.save(createTennisCourtMapper.map(tennisCourtDTO));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void deleteTennisCourt(Long id) {
        courtRepository.deleteById(id);
    }
}
