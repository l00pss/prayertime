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
public class City {
    private static final transient String countryName = "Azərbaycan";

    private String dayOfYear;
    private String cityOfName;
    private String qiblaAngle;
    private String magdeg;
    private BaseTime baseTime;
    private ExtraTime extraTime;

    public City(String dayOfYear, String cityOfName, String qiblaAngle, String magdeg,
                BaseTime baseTime, ExtraTime extraTime) {
        this.dayOfYear = dayOfYear;
        this.cityOfName = cityOfName;
        this.qiblaAngle = qiblaAngle;
        this.magdeg = magdeg;
        this.baseTime = baseTime;
        this.extraTime = extraTime;
    }
}
