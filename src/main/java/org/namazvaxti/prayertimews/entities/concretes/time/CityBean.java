package org.namazvaxti.prayertimews.entities.concretes.time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.chrono.HijrahDate;
import java.util.Date;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor
public class CityBean {
    private static final transient String countryName = "Azərbaycan";

    private int id;

    private String cityOfName;
    private double qiblaAngle;

    private double magdeg;

    private Date todayDate;

    private HijrahDate todayHijrahDate;


    private List<BaseTime> idOfCityBeanBase;

    private  List<ExtraTime> idOfCityBeanExtra;
}
