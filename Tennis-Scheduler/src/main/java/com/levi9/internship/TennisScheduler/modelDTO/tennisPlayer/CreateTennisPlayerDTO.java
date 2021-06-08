package com.levi9.internship.TennisScheduler.modelDTO.tennisPlayer;

import com.levi9.internship.TennisScheduler.modelDTO.reservation.ReservationDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateTennisPlayerDTO {

    private String name;
    private String lastName;
    private String email;
    private LocalDateTime dateOfBirth;
    //private Set<ReservationDTO> reservations = new HashSet<ReservationDTO>();

}