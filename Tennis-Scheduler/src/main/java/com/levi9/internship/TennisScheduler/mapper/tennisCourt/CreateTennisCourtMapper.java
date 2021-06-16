package com.levi9.internship.tennisscheduler.mapper.tenniscourt;

import com.levi9.internship.tennisscheduler.model.TennisCourt;
import com.levi9.internship.tennisscheduler.modeldto.tenniscourt.CreateTennisCourtDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateTennisCourtMapper {
    CreateTennisCourtDTO map(TennisCourt tennisCourt);
    TennisCourt map(CreateTennisCourtDTO source);
}
