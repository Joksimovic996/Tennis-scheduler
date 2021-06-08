package com.levi9.internship.TennisScheduler.serviceImpl;


import com.levi9.internship.TennisScheduler.exceptions.TennisException;
import com.levi9.internship.TennisScheduler.mapper.tennisPlayer.CreateTennisPlayerMapper;
import com.levi9.internship.TennisScheduler.mapper.tennisPlayer.TennisPlayerMapper;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
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

        TennisPlayer tennisPlayer=tennisPlayerRepository.getById(id);
        if(tennisPlayer!=null)
        {
            return tennisPlayerMapper.map(tennisPlayer);
        }
        return null;
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
    public Boolean updateTennisPlayer(CreateTennisPlayerDTO tennisPlayerDTO, Long id) {
        TennisPlayer temp = tennisPlayerRepository.getById(id);
        if ( temp != null )  {
            tennisPlayerRepository.save(createTennisPlayerMapper.map(tennisPlayerDTO));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void deleteTennisPlayer(Long id) {
        tennisPlayerRepository.deleteById(id);
    }

    @Override
    public TennisPlayerDTO getTennisPlayerByEmail(String email) {
        try {
            return tennisPlayerMapper.map(tennisPlayerRepository.getTennisPlayerByEmail(email));
        } catch (Exception e) {
            throw new TennisException(HttpStatus.NOT_FOUND, "GET METHOD: Tennis Court with that name does not exist!");
        }
    }
}
