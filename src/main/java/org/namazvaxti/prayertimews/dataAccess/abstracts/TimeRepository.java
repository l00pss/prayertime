package org.namazvaxti.prayertimews.dataAccess.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.entities.concretes.CityBean;
import org.namazvaxti.prayertimews.entities.concretes.time.City;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TimeRepository {
    Map<Integer,City> getAllDataAsYearly(Integer indexOfCity) throws BaseException, CloneNotSupportedException;
    List<CityBean> getListOfCities();

    City getDatesOfDay(Integer idexOfCity) throws BaseException;
    City getDatesOfDay(Integer idexOfCity, Date date) throws DataNotFoundException, NullValueException;

    Map<Integer,City> getWeeklyDates(Integer idexOfCity) throws BaseException;
    Map<Integer,City> getMonthlyDates(Integer idexOfCity)throws BaseException;
}
