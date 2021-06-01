package com.levi9.internship.TennisScheduler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TennisCourt {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(
            name = "tennis_court_name",
            unique = true,
            nullable = false
    )
    private String name;

    @ManyToOne
    @JoinColumn(name = "court_price_id")
    private TennisCourtPrice courtPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tennisCourtId", fetch = FetchType.LAZY)
    private Set<TimeSlot> timeSlots;
    
}
