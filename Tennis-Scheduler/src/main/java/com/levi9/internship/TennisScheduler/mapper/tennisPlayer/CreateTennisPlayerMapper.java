package com.levi9.internship.TennisScheduler.mapper.tennisPlayer;


import com.levi9.internship.TennisScheduler.model.TennisPlayer;
import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.CreateTennisPlayerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateTennisPlayerMapper {
    CreateTennisPlayerDTO map(TennisPlayer tennisCourt);
    TennisPlayer map(CreateTennisPlayerDTO source);
}
