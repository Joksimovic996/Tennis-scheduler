package com.levi9.internship.TennisScheduler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TennisPlayer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(
            name="email_address",
            unique = true,
            nullable = false
    )
    private String email;

    @Column(name="date_of_birth")
    private LocalDateTime dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tennisPlayerId")
    private Set<Reservation> reservations;
}
