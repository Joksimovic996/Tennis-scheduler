package com.levi9.internship.TennisScheduler.modelDTO.creditCardDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Month;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDTO {
    private Long creditCardNumber;
    private String creditCardValidDate;
    private int creditCardCvcCode;
}
