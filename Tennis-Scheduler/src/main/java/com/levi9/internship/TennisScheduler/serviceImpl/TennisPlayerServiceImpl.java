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
    public TennisPlayer addTennisPalyer(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.save(tennisPlayer);
    }

    @Override
    public TennisPlayer updateTennisPlayer(TennisPlayer tennisPlayer) {
        return tennisPlayerRepository.save(tennisPlayer);
    }

    @Override
    public void deleteTennisPlayerById(Long id) {
        tennisPlayerRepository.deleteById(id);
    }


}
