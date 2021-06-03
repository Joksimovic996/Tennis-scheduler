package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TennisPlayerService {

    public TennisPlayer getTennisPlayer(Long id);
    public List<TennisPlayer> getAllTennisPlayers();
    public TennisPlayer addTennisPalyer(TennisPlayer tennisPlayer);
    public TennisPlayer updateTennisPlayer(TennisPlayer tennisPlayer);
    public void deleteTennisPlayerById(Long id);
}
