package com.levi9.internship.TennisScheduler.serviceImpl;

import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.repository.TennisCourtRepository;
import com.levi9.internship.TennisScheduler.service.TennisCourtService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TennisCourtServiceImpl implements TennisCourtService {

    private final TennisCourtRepository courtRepository;

    public TennisCourtServiceImpl(TennisCourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    @Override
    public TennisCourt getTennisCourt(Long id) {
        TennisCourt tennisCourt = courtRepository.getById(id);
        if (tennisCourt != null) {
            return tennisCourt;
        }
        return null;
    }

    @Override
    public List<TennisCourt> getAllCourts() {
        return courtRepository.findAll();
    }
}
