package org.namazvaxti.prayertimews.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DAILY_WORDS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTEXT")
    private String context;
}
