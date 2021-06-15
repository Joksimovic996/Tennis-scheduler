package com.levi9.internship.TennisScheduler.serviceImpl;


import com.levi9.internship.TennisScheduler.exceptions.TennisException;
import com.levi9.internship.TennisScheduler.mapper.tennisPlayer.CreateTennisPlayerMapper;
import com.levi9.internship.TennisScheduler.mapper.tennisPlayer.TennisPlayerMapper;
import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.CreateTennisPlayerDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.TennisPlayerDTO;
import com.levi9.internship.TennisScheduler.repository.TennisPlayerRepository;
import com.levi9.internship.TennisScheduler.service.TennisPlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TennisPlayerServiceImpl implements TennisPlayerService {


    private final TennisPlayerRepository tennisPlayerRepository;
    private final TennisPlayerMapper tennisPlayerMapper;
    private final CreateTennisPlayerMapper createTennisPlayerMapper;


    public TennisPlayerServiceImpl(TennisPlayerRepository tennisPlayerRepository, TennisPlayerMapper tennisPlayerMapper, CreateTennisPlayerMapper createTennisPlayerMapper)
    {
        this.tennisPlayerRepository=tennisPlayerRepository;
        this.tennisPlayerMapper = tennisPlayerMapper;
        this.createTennisPlayerMapper = createTennisPlayerMapper;
    }


    @Override
    public TennisPlayerDTO getTennisPlayer(Long id) {
        return tennisPlayerMapper.map(tennisPlayerRepository.getById(id));
    }

    @Override
    public List<TennisPlayerDTO> getAllPlayers() {
        List<TennisPlayer> tennisPlayers=tennisPlayerRepository.findAll();
        List<TennisPlayerDTO> tennisPlayerDTOS=new ArrayList<>();
            if (!tennisPlayers.isEmpty()) {
                for (TennisPlayer temp : tennisPlayers) {
                    tennisPlayerDTOS.add(tennisPlayerMapper.map(temp));
                }
                return tennisPlayerDTOS;
            }
        return null;
    }

    @Override
    public void addTennisPlayer(CreateTennisPlayerDTO tennisPlayerDTO) {
        TennisPlayer tennisPlayer = new TennisPlayer();
        tennisPlayer = createTennisPlayerMapper.map(tennisPlayerDTO);
        tennisPlayerRepository.save(tennisPlayer);
    }

    @Override
    public void updateTennisPlayer(CreateTennisPlayerDTO tennisPlayerDTO, Long id) {
        TennisPlayer tennisPlayer = tennisPlayerRepository.getTennisPlayerByEmail(tennisPlayerDTO.getEmail());
        if(tennisPlayer != null) {
            throw new TennisException(HttpStatus.BAD_REQUEST,"Tennis Player with that email already exist!");
        }
        TennisPlayer updatedTennisPlayer = createTennisPlayerMapper.map(tennisPlayerDTO);
        updatedTennisPlayer.setId(id);
        tennisPlayerRepository.save(updatedTennisPlayer);
    }

    @Override
    public void deleteTennisPlayer(Long id) {
        tennisPlayerRepository.deleteById(id);
    }

    @Override
    public TennisPlayerDTO getTennisPlayerByEmail(String email) {
        TennisPlayer tennisPlayer = tennisPlayerRepository.getTennisPlayerByEmail(email);
        if (tennisPlayer == null)
            throw new TennisException(HttpStatus.NOT_FOUND, "Tennis Player with that email does not exist!");
        return tennisPlayerMapper.map(tennisPlayer);
    }
}
