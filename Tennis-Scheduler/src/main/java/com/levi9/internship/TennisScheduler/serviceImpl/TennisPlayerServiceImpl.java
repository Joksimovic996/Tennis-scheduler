package com.levi9.internship.TennisScheduler.serviceImpl;


import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.repository.TennisCourtRepository;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import com.levi9.internship.TennisScheduler.service.TennisPlayerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class TennisPlayerServiceImpl implements TennisPlayerService {


    private final TennisPlayerRepository tennisPlayerRepository;

    public TennisPlayerServiceImpl(TennisPlayerRepository tennisPlayerRepository )
    {
        this.tennisPlayerRepository=tennisPlayerRepository;
    }


    @Override
    public TennisPlayer getTennisPlayer(Long id) {
        TennisPlayer tp= tennisPlayerRepository.getById(id);
       return tp;
    }

    @Override
    public List<TennisPlayer> getAllTennisPlayers() {
       return tennisPlayerRepository.findAll();
    }

    @Override
    public void addTennisPlayer(TennisPlayer tennisPlayer) {
        tennisPlayerRepository.save(tennisPlayer);
    }


}
