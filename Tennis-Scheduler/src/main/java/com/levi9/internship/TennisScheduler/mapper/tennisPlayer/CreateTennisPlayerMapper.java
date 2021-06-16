package com.levi9.internship.tennisscheduler.mapper.tennisplayer;


import com.levi9.internship.tennisscheduler.model.TennisPlayer;
import com.levi9.internship.tennisscheduler.modeldto.tennisplayer.CreateTennisPlayerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateTennisPlayerMapper {
    @Mapping(target = "password",ignore = true)
    CreateTennisPlayerDTO map(TennisPlayer tennisCourt);
    @Mapping(target = "password",ignore = true)
    TennisPlayer map(CreateTennisPlayerDTO source);
}
