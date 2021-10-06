package org.namazvaxti.prayertimews.entities.concretes.time;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements  Cloneable{
    private static final transient String countryName = "Azərbaycan";
    private String dayOfYear;
    private String cityOfName;
    private String qiblaAngle;
    private String magdeg;
    private BaseTime baseTime;
    private ExtraTime extraTime;

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public City(City city){
        this.dayOfYear = city.getDayOfYear();
        this.cityOfName = city.getCityOfName();
        this.qiblaAngle = city.getQiblaAngle();
        this.magdeg = city.getMagdeg();
        baseTime = new BaseTime();
        extraTime = new ExtraTime();

        baseTime.setDayOfYear(city.getBaseTime().getDayOfYear());
        baseTime.setTodayDate(city.getBaseTime().getTodayDate());
        baseTime.setTodayHijrahDate(city.getBaseTime().getTodayHijrahDate());
        baseTime.setQiblaClock(city.getBaseTime().getQiblaClock());
        baseTime.setImsaq(city.getBaseTime().getImsaq());
        baseTime.setSabah(city.getBaseTime().getSabah());
        baseTime.setGunes(city.getBaseTime().getGunes());
        baseTime.setGunorta(city.getBaseTime().getGunorta());
        baseTime.setIkindi(city.getBaseTime().getIkindi());
        baseTime.setAxsam(city.getBaseTime().getAxsam());
        baseTime.setYatsi(city.getBaseTime().getYatsi());

        extraTime.setSeher(city.getExtraTime().getSeher());
        extraTime.setIsrak(city.getExtraTime().getIsrak());
        extraTime.setDahve(city.getExtraTime().getDahve());
        extraTime.setKerahat(city.getExtraTime().getKerahat());
        extraTime.setAsri_sani(city.getExtraTime().getAsri_sani());
        extraTime.setIsfirar(city.getExtraTime().getIsfirar());
        extraTime.setIstibak(city.getExtraTime().getIstibak());
        extraTime.setTeheccud(city.getExtraTime().getTeheccud());
        extraTime.setMidnight(city.getExtraTime().getMidnight());
        extraTime.setIsa_sani(city.getExtraTime().getIsa_sani());
    }
}
