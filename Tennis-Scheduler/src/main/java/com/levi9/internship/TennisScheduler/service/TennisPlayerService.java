package com.levi9.internship.TennisScheduler.service;

import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.CreateTennisPlayerDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.TennisPlayerDTO;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TennisPlayerService {


    public TennisPlayerDTO getTennisPlayer(Long id);

    public List<TennisPlayerDTO> getAllPlayers();

    public void addTennisPlayer(CreateTennisPlayerDTO tennisCourtDTO);

    public Boolean updateTennisPlayer(CreateTennisPlayerDTO tennisPlayerDTO, Long id);

    public void deleteTennisPlayer(Long id);

    public TennisPlayerDTO getTennisPlayerByEmail(String email);
}
