package com.levi9.internship.TennisScheduler.model;

import com.levi9.internship.TennisScheduler.enumerations.TennisCourtType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "court_price")
public class TennisCourtPrice {

    @Id
    @GeneratedValue (strategy = IDENTITY)
    private Long id;
    @Column (name = "court_type")
    private TennisCourtType courtType;
    @Column (name = "price_per_minute")
    private Double pricePerMinute;

    @OneToMany (mappedBy = "courtPrice", fetch = LAZY, cascade = ALL)
    private Set<TennisCourt> tennisCourts;
}
