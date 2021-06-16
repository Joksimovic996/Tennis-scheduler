package com.levi9.internship.tennisscheduler.modeldto.tenniscourt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UpdateTennisCourtDTO {
    private String courtType;
    private Double pricePerMinute;
}
