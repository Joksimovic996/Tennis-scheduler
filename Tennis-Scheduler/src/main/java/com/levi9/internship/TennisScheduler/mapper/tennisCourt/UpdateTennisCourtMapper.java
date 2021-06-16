package com.levi9.internship.tennisscheduler.mapper.tenniscourt;

import com.levi9.internship.tennisscheduler.model.TennisCourt;
import com.levi9.internship.tennisscheduler.modeldto.tenniscourt.UpdateTennisCourtDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateTennisCourtMapper {
    UpdateTennisCourtDTO map(TennisCourt tennisCourt);
    TennisCourt map(UpdateTennisCourtDTO source);
}
