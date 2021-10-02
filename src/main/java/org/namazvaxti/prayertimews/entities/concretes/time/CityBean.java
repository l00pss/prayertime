package org.namazvaxti.prayertimews.entities.concretes.time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.chrono.HijrahDate;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "CITY")
@Data @NoArgsConstructor @AllArgsConstructor
public class CityBean {
    private static final transient String countryName = "Azərbaycan";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "cityId")
    private City city;

    @Column(name = "CITY_OF_NAME")
    private String cityOfName;

    @Column(name = "QIBLA_ANGLE")
    private double qiblaAngle;

    @Column(name = "MAGDEG")
    private double magdeg;
//
//    @Column(name = "DATE")
//    private Date todayDate;

//    @Column(name = "HIJRAH_DATE")
//    private HijrahDate todayHijrahDate;


    @OneToMany(mappedBy = "cityBeanBase",fetch = FetchType.LAZY)
    private List<BaseTime> idOfCityBeanBase;

    @OneToMany(mappedBy = "cityBeanExtra",fetch = FetchType.LAZY)
    private  List<ExtraTime> idOfCityBeanExtra;
}
