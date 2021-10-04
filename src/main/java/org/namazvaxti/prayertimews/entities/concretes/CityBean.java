package org.namazvaxti.prayertimews.entities.concretes;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityBean {
    private int id;
    private int indexOfCity;
    private String nameOfCity;

    public CityBean(int id, int indexOfCity, String nameOfCity) {
        this.id = id;
        this.indexOfCity = indexOfCity;
        this.nameOfCity = nameOfCity;
    }
}
