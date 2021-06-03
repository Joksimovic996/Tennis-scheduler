package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TennisPlayerService {

    public TennisPlayer getTennisPlayer(Long id);
    public List<TennisPlayer> getAllTennisPlayers();
    public void addTennisPlayer(@RequestBody TennisPlayer tennisPlayer);
}
