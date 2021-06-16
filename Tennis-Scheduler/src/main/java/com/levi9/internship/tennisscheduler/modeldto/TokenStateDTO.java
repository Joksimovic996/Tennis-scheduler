package com.levi9.internship.tennisscheduler.modeldto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenStateDTO {
    private String accessToken;
    private int expiresIn;
}
