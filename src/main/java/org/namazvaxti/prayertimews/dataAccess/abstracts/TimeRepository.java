package org.namazvaxti.prayertimews.dataAccess.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.entities.concretes.time.City;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;

public interface TimeRepository {
    JsonStructure getAllDataAsJson(Integer indexOfCity) throws BaseException;
    JsonStructure getListOfCities();

    City getDatesOfDay(Integer idexOfCity) throws BaseException;
    City getDatesOfDay(Integer idexOfCity, Date date);

    List<City> getWeeklyDates(Integer idexOfCity);
    List<City> getMonthlyDates(Integer idexOfCity);
}
