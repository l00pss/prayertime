package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraTime {

    @Column(name = "DAY_OF_YEAR")
    private int dayOfYear;


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
