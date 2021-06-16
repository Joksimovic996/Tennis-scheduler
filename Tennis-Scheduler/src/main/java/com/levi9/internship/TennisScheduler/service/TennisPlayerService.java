package com.levi9.internship.tennisscheduler.service;

import com.levi9.internship.tennisscheduler.modeldto.tennisplayer.CreateTennisPlayerDTO;
import com.levi9.internship.tennisscheduler.modeldto.tennisplayer.TennisPlayerDTO;

import java.util.List;

public interface TennisPlayerService {


    TennisPlayerDTO getTennisPlayer(Long id);

    List<TennisPlayerDTO> getAllPlayers();

    TennisPlayerDTO addTennisPlayer(CreateTennisPlayerDTO tennisCourtDTO);

    void updateTennisPlayer(CreateTennisPlayerDTO tennisPlayerDTO, Long id);

    void deleteTennisPlayer(Long id);

    TennisPlayerDTO getTennisPlayerByEmail(String email);
}
