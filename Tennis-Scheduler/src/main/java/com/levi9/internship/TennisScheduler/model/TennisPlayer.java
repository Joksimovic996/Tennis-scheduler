package com.levi9.internship.TennisScheduler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TennisPlayer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(
            name="email",
            unique = true,
            nullable = false
    )
    private String email;

    @Column(name="date_of_brith")
    private LocalDateTime dateOfBirth;
}
