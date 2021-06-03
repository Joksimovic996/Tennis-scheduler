package com.levi9.internship.TennisScheduler.modelDTO.tennisCourt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreateTennisCourtDTO {
    private String name;
    private String courtType;
    private Double pricePerMinute;
}
