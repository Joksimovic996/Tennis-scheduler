package com.levi9.internship.TennisScheduler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_slot")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date_and_time")
    private LocalDateTime startDateAndTime;

    @Column(name = "end_date_and_time")
    private LocalDateTime endDateAndTime;

    @ManyToOne
    @JoinColumn(name = "tennis_court_id")
    private TennisCourt tennisCourtId;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservationId;
}
