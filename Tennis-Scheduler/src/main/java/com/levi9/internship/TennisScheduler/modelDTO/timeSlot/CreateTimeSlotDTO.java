package com.levi9.internship.TennisScheduler.modelDTO.timeSlot;

import com.levi9.internship.TennisScheduler.model.Reservation;
import com.levi9.internship.TennisScheduler.model.TennisCourt;
import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;
import com.levi9.internship.TennisScheduler.modelDTO.tennisCourt.TennisCourtDTO;
import com.levi9.internship.TennisScheduler.validation.ValidCreateTimeSlotDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ValidCreateTimeSlotDTO
public class CreateTimeSlotDTO {
    @FutureOrPresent
    @NotNull
    private LocalDateTime startDateAndTime;
    @FutureOrPresent
    @NotNull
    private LocalDateTime endDateAndTime;
}
