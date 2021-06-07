package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.exceptions.TennisException;
import com.levi9.internship.TennisScheduler.mapper.tennisCourt.CreateTennisCourtMapper;
import com.levi9.internship.TennisScheduler.mapper.tennisCourt.TennisCourtMapper;
import com.levi9.internship.TennisScheduler.mapper.tennisCourt.UpdateTennisCourtMapper;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.CreateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.UpdateTennisCourtDTO;
import com.levi9.internship.TennisScheduler.repository.TennisCourtRepository;
import com.levi9.internship.TennisScheduler.service.TennisCourtService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TennisCourtServiceImpl implements TennisCourtService {

    private final TennisCourtRepository courtRepository;
    private final TennisCourtMapper tennisCourtMapper;
    private final CreateTennisCourtMapper createTennisCourtMapper;
    private final UpdateTennisCourtMapper updateTennisCourtMapper;



    public TennisCourtServiceImpl(TennisCourtRepository courtRepository, TennisCourtMapper tennisCourtMapper, CreateTennisCourtMapper createTennisCourtMapper, UpdateTennisCourtMapper updateTennisCourtMapper) {
        this.courtRepository = courtRepository;
        this.tennisCourtMapper = tennisCourtMapper;
        this.createTennisCourtMapper = createTennisCourtMapper;
        this.updateTennisCourtMapper = updateTennisCourtMapper;
    }

    @Override
    public void addTennisCourt(CreateTennisCourtDTO tennisCourtDTO) {
        TennisCourt newCourt = new TennisCourt();
        newCourt = createTennisCourtMapper.map(tennisCourtDTO);
        courtRepository.save(newCourt);
    }

    @Override
    public TennisCourtDTO getTennisCourtById(Long id) {
        try {
            return tennisCourtMapper.map(courtRepository.findById(id).get());
        } catch (Exception e) {
            throw new TennisException(HttpStatus.NOT_FOUND, "GET METHOD: Tennis Court with that id does not exist!");
        }

    }

    @Override
    public TennisCourtDTO getTennisCourtByName(String name) {
        try {
            return tennisCourtMapper.map(courtRepository.getTennisCourtByName(name));
        } catch (Exception e) {
            throw new TennisException(HttpStatus.NOT_FOUND, "GET METHOD: Tennis Court with that name does not exist!");
        }
    }

    @Override
    public List<TennisCourtDTO> getAllCourts() {
        List<TennisCourtDTO> tennisCourts = new ArrayList<>();
        courtRepository.findAll().forEach(tennisCourt -> tennisCourts.add(tennisCourtMapper.map(tennisCourt)));
        return tennisCourts;
    }

    @Override
    public void updateTennisCourt(UpdateTennisCourtDTO tennisCourtDTO, Long id) {
        try {
            TennisCourt temp = courtRepository.getById(id);
            TennisCourt updated = updateTennisCourtMapper.map(tennisCourtDTO);
            updated.setId(temp.getId());
            updated.setName(temp.getName());
            courtRepository.save(updated);
        } catch (Exception e) {
            throw new TennisException(HttpStatus.NOT_FOUND, "UPDATE METHOD: Tennis Court with that id does not exist!");
        }
    }

    @Override
    public void deleteTennisCourt(Long id) {
        courtRepository.deleteById(id);
    }
}
