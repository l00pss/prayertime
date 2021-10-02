package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DAILY_DATA_EXTRA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DAY_OF_YEAR")
    private int dayOfYear;

    @ManyToOne(targetEntity = CityBean.class)
    @JoinColumn(name = "idOfCityBeanExtra")
    private CityBean cityBeanExtra;

    private String israk;
    private String dahve;
    private String kerahat;
    private String asri_sani;
    private String isfirar;
    private String istibak;
    private String isa_sani;
    private String midnight;
    private String teheccud;
    private String seher;
    private String qiblaClock;
}
