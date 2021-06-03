package com.levi9.internship.TennisScheduler.mapper.timeSlot;

import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlot map(TimeSlotDTO timeSlotDTO);
    TimeSlotDTO map(TimeSlot timeSlot);
}
