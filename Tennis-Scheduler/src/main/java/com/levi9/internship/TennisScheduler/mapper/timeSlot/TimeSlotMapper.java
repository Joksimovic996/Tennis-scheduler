package com.levi9.internship.tennisscheduler.mapper.timeslot;

import com.levi9.internship.tennisscheduler.mapper.reservation.ReservationMapper;
import com.levi9.internship.tennisscheduler.mapper.tenniscourt.TennisCourtMapper;
import com.levi9.internship.tennisscheduler.model.TimeSlot;
import com.levi9.internship.tennisscheduler.modeldto.timeslot.TimeSlotDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { TennisCourtMapper.class, ReservationMapper.class })
public interface TimeSlotMapper {
    TimeSlot map(TimeSlotDTO timeSlotDTO);
    TimeSlotDTO map(TimeSlot timeSlot);
}
