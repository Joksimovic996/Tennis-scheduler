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
import java.util.Optional;

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
    public TennisCourtDTO getTennisCourtById(Long id) {
        Optional<TennisCourt> tennisCourt = courtRepository.findById(id);
        if (tennisCourt != null) {
            return tennisCourtMapper.map(tennisCourt.get());
        }
        return null;
    }

    @Override
    public TennisCourtDTO getTennisCourtByName(String name) {
        TennisCourt tennisCourt = courtRepository.getTennisCourtByName(name);
        if (tennisCourt != null) {
            return tennisCourtMapper.map(tennisCourt);
        }
        return null;
    }

    @Override
    public List<TennisCourtDTO> getAllCourts() {
        List<TennisCourtDTO> tennisCourts = new ArrayList<>();
        courtRepository.findAll().forEach(tennisCourt -> tennisCourts.add(tennisCourtMapper.map(tennisCourt)));
        return tennisCourts;
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
