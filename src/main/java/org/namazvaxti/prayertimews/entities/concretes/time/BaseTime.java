package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DAILY_DATA_BASE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DAY_OF_YEAR")
    private int dayOfYear;
    @ManyToOne(targetEntity = CityBean.class)
    @JoinColumn(name = "idOfCityBeanBase")
    private CityBean cityBeanBase;

    private String imsaq;
    private String sabah;
    private String gunes;
    private String gunorta;
    private String ikindi;
    private String axsam;
    private String yatsi;
}
