package com.levi9.internship.TennisScheduler.mapper.timeSlot;

import com.levi9.internship.TennisScheduler.mapper.reservation.ReservationMapper;
import com.levi9.internship.TennisScheduler.mapper.tennisCourt.TennisCourtMapper;
import com.levi9.internship.TennisScheduler.model.TimeSlot;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateTimeSlotMapper {
    CreateTimeSlotDTO map(TimeSlot timeSlot);
    TimeSlot map(CreateTimeSlotDTO createTimeSlotDTO);
}
