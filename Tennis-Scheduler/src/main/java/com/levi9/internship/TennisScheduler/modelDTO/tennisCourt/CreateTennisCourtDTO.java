package com.levi9.internship.TennisScheduler.modelDTO.tennisCourt;

import com.levi9.internship.TennisScheduler.modelDTO.timeSlot.TimeSlotDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateTennisCourtDTO {
    private String name;
    private String courtType;
    private Double pricePerMinute;
    private Set<TimeSlotDTO> timeslots = new HashSet<TimeSlotDTO>();
}
