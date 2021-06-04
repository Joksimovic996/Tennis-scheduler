package com.levi9.internship.TennisScheduler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reservation {

    @Id
    @SequenceGenerator(name = "reservation_seq_gen", sequenceName = "reservation_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "reservation_seq_gen")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tennis_player_id")
    private TennisPlayer tennisPlayerId;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "timeslots")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationId", fetch = FetchType.LAZY)
    private Set<TimeSlot> timeSlots;

}
