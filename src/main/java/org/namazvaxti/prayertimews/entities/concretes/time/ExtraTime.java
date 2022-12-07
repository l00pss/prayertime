package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraTime implements Cloneable{

    private int id;
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

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

}
