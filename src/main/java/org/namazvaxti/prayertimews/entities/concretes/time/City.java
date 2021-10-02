package org.namazvaxti.prayertimews.entities.concretes.time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CITY_LIST")
@Data @NoArgsConstructor @AllArgsConstructor
public class City {
    @Id
    private int cityId;
    private int indexOfCity;

    @OneToOne(mappedBy = "city",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private CityBean cityBean;
}
