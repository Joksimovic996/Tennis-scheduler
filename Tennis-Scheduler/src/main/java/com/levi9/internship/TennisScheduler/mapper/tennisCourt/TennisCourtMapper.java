package com.levi9.internship.tennisscheduler.mapper.tenniscourt;

import com.levi9.internship.tennisscheduler.model.TennisCourt;
import com.levi9.internship.tennisscheduler.modeldto.tenniscourt.TennisCourtDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TennisCourtMapper {
    TennisCourt map(TennisCourtDTO source);
    TennisCourtDTO map(TennisCourt tennisCourt);
}
