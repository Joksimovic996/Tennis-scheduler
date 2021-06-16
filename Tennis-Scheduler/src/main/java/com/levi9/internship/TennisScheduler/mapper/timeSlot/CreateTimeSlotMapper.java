package com.levi9.internship.tennisscheduler.mapper.timeslot;

import com.levi9.internship.tennisscheduler.model.TimeSlot;
import com.levi9.internship.tennisscheduler.modeldto.timeslot.CreateTimeSlotDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateTimeSlotMapper {
    @Mapping(target = "tennisCourt",ignore = true)
    CreateTimeSlotDTO map(TimeSlot timeSlot);
    @Mapping(target = "tennisCourt",ignore = true)
    TimeSlot map(CreateTimeSlotDTO createTimeSlotDTO);
}
