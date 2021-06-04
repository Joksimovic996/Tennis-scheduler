package com.levi9.internship.TennisScheduler.mapper.timeSlot;

import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateTimeSlotMapper {
    CreateTimeSlotDTO map(TimeSlot timeSlot);
    TimeSlot map(CreateTimeSlotDTO createTimeSlotDTO);
}
