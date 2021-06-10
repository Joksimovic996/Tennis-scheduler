package com.levi9.internship.TennisScheduler.modelDTO.reservation;

import com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer.TennisPlayerDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.CreateTimeSlotDTO;
import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;
import com.levi9.internship.TennisScheduler.validation.ValidCreateTimeSlotDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CreateReservationDTO {

    private String paymentType;
    @ValidCreateTimeSlotDTO
    private Set<CreateTimeSlotDTO> timeSlots;
}
