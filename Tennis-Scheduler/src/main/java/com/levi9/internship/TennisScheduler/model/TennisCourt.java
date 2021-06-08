package com.levi9.internship.TennisScheduler.model;

import com.levi9.internship.TennisScheduler.enumerations.TennisCourtType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TennisCourt {

    @Id
    @SequenceGenerator(name = "court_seq_gen", sequenceName = "tennis_court_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "court_seq_gen")
    private Long id;

    @Column(
            name = "tennis_court_name",
            unique = true,
            nullable = false
    )
    private String name;

    @Column (name = "court_type")
    @Enumerated(EnumType.ORDINAL)
    private TennisCourtType courtType;

    @Column (name = "price_per_minute")
    private Double pricePerMinute;

    @OneToMany(mappedBy = "tennisCourtId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TimeSlot> timeSlots = new HashSet<>();
}
