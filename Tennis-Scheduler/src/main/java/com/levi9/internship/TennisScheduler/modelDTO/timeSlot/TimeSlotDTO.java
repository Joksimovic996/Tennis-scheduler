package com.levi9.internship.TennisScheduler.modelDTO.timeSlot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TimeSlotDTO {
    private Long id;
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
}
