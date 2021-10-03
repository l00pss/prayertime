package org.namazvaxti.prayertimews.dataAccess.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;

public interface TimeRepository {
    JsonStructure getAllDataAsJson(Integer indexOfCity) throws BaseException;
    JsonStructure getListOfCities();

    CityBean getDatesOfDay(Integer idexOfCity) throws BaseException;
    CityBean getDatesOfDay(Integer idexOfCity, Date date);

    List<CityBean> getWeeklyDates(Integer idexOfCity);
    List<CityBean> getMonthlyDates(Integer idexOfCity);
}
