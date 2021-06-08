package com.levi9.internship.TennisScheduler.mapper.reservation;

import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.CreateReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateReservationMapper {
    @Mapping(target = "tennisPlayerId", ignore = true)
    CreateReservationDTO map(Reservation reservation);
    @Mapping(target = "tennisPlayerId", ignore = true)
    Reservation map(CreateReservationDTO createReservationDTO);
}
