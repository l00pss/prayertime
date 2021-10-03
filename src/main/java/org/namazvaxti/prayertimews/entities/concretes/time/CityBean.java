package org.namazvaxti.prayertimews.entities.concretes.time;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.chrono.HijrahDate;
import java.util.Date;
import java.util.List;

@Component
@Getter @Setter
@NoArgsConstructor
public class CityBean {
    private static final transient String countryName = "Azərbaycan";

    private int dayOfYear;
    private String cityOfName;
    private double qiblaAngle;
    private double magdeg;
    private Date todayDate;
    private HijrahDate todayHijrahDate;
    private BaseTime baseTime;
    private ExtraTime extraTime;

    public CityBean(int dayOfYear, String cityOfName, double qiblaAngle, double magdeg, Date todayDate,
                    HijrahDate todayHijrahDate, BaseTime baseTime,ExtraTime extraTime) {
        this.dayOfYear = dayOfYear;
        this.cityOfName = cityOfName;
        this.qiblaAngle = qiblaAngle;
        this.magdeg = magdeg;
        this.todayDate = todayDate;
        this.todayHijrahDate = todayHijrahDate;
        this.baseTime = baseTime;
        this.extraTime = extraTime;
    }
}
