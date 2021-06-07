package com.levi9.internship.TennisScheduler.mapper.timeSlot;

import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateTimeSlotMapper {
    @Mapping(target = "tennisCourtId", ignore = true)
    @Mapping(target = "reservationId", ignore = true)
    CreateTimeSlotDTO map(TimeSlot timeSlot);

    @Mapping(target = "tennisCourtId", ignore = true)
    @Mapping(target = "reservationId", ignore = true)
    TimeSlot map(CreateTimeSlotDTO createTimeSlotDTO);
}
