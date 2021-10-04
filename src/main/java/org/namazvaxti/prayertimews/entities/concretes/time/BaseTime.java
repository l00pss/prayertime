package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseTime {

    private String dayOfYear;
    private String todayDate;
    private String todayHijrahDate;
    private String qiblaClock;
    private String imsaq;
    private String sabah;
    private String gunes;
    private String gunorta;
    private String ikindi;
    private String axsam;
    private String yatsi;
}
