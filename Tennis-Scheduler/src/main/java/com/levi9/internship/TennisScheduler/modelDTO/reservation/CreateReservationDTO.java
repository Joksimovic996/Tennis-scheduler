package com.levi9.internship.TennisScheduler.modelDTO.reservation;

import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.TennisPlayerDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CreateReservationDTO {
    private TennisPlayerDTO playerId;
    private LocalDateTime reservationDate;
    //private Set<TimeSlotDTO> timeSlots;
}
