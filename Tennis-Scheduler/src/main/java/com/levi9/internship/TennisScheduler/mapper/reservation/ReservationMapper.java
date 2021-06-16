package com.levi9.internship.tennisscheduler.mapper.reservation;

import com.levi9.internship.tennisscheduler.mapper.tennisplayer.TennisPlayerMapper;
import com.levi9.internship.tennisscheduler.model.Reservation;
import com.levi9.internship.tennisscheduler.modeldto.reservation.ReservationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TennisPlayerMapper.class)
public interface ReservationMapper {
    Reservation map(ReservationDTO reservationDTO);
    ReservationDTO map(Reservation reservation);
}
