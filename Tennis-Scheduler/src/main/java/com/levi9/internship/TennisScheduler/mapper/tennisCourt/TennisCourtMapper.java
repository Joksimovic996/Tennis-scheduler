package com.levi9.internship.TennisScheduler.mapper.tennisCourt;

import com.levi9.internship.TennisScheduler.mapper.timeSlot.TimeSlotMapper;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TimeSlotMapper.class)
public interface TennisCourtMapper {
    TennisCourt map(TennisCourtDTO source);
    TennisCourtDTO map(TennisCourt tennisCourt);
}
