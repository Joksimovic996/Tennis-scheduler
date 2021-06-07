package com.levi9.internship.TennisScheduler.modelDTO.timeSlot;

import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class CreateTimeSlotDTO {
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
    private TennisCourtDTO tennisCourt;
    private ReservationDTO reservationId;
}
