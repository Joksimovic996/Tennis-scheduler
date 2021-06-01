package com.levi9.internship.TennisScheduler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //private TennisPlayer tennisPlayerId;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "timeslots")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId", fetch = FetchType.LAZY)
    private Set<TimeSlot> timeSlots;

}
