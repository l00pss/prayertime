package org.namazvaxti.prayertimews.entities.concretes;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope(scopeName = "prototype")
public class CityBean {
    private int id;
    private int indexOfCity;
    private String nameOfCity;

    @Override
    public String toString() {
        return "CityBean{" +
                "id=" + id +
                ", indexOfCity=" + indexOfCity +
                ", nameOfCity='" + nameOfCity + '\'' +
                '}';
    }
}
