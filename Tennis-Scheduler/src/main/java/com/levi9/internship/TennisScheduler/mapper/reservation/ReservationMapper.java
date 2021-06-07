package com.levi9.internship.TennisScheduler.mapper.reservation;

import com.levi9.internship.TennisScheduler.mapper.timeSlot.TimeSlotMapper;
import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation map(ReservationDTO reservationDTO);
    ReservationDTO map(Reservation reservation);
}
