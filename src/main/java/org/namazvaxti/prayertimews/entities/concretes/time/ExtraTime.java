package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "DAILY_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
