package com.levi9.internship.tennisscheduler.mapper.reservation;

import com.levi9.internship.tennisscheduler.model.Reservation;
import com.levi9.internship.tennisscheduler.modeldto.reservation.CreateReservationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateReservationMapper {
    CreateReservationDTO map(Reservation reservation);
    Reservation map(CreateReservationDTO createReservationDTO);
}
