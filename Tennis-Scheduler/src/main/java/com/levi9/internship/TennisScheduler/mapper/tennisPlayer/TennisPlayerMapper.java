package com.levi9.internship.tennisscheduler.mapper.tennisplayer;


import com.levi9.internship.tennisscheduler.model.TennisPlayer;
import com.levi9.internship.tennisscheduler.modeldto.tennisplayer.TennisPlayerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TennisPlayerMapper {
    TennisPlayer map(TennisPlayerDTO source);
    TennisPlayerDTO map(TennisPlayer tennisPlayer);
}
