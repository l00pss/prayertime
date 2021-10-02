package org.namazvaxti.prayertimews.entities.concretes.time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.chrono.HijrahDate;
import java.util.Date;


@Entity
@Table(name = "DAILY_DATA")
@Data @NoArgsConstructor @AllArgsConstructor
public class DailyData {
    private static final transient String countryName = "Azərbaycan";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dayOfYear;

    @Column(name = "CITY_OF_NAME")
    private String cityOfName;

    @Column(name = "QIBLA_ANGLE")
    private double qiblaAngle;

    @Column(name = "MAGDEG")
    private double magdeg;

    @Column(name = "DATE")
    private Date todayDate;

    @Column(name = "HIJRAH_DATE")
    private HijrahDate todayHijrahDate;


    @OneToMany
    private  BaseTime baseTimes;

    @OneToMany
    private  ExtraTime extraTimes;
}
