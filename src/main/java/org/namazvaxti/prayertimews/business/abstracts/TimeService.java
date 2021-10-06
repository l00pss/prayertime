package org.namazvaxti.prayertimews.business.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.entities.concretes.CityBean;
import org.namazvaxti.prayertimews.entities.concretes.time.City;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TimeService {

    SuccessDataResult<Map<Integer,City>> getAllDataAsYearly(Integer indexOfCity) throws BaseException, CloneNotSupportedException;
    SuccessDataResult<List<CityBean>> getListOfCities() throws BaseException;

    SuccessDataResult<City> getDatesOfDay(Integer indexOfCity)throws BaseException;
    SuccessDataResult<City> getDatesOfDay(Integer idexOfCity, Date date) throws BaseException;

    SuccessDataResult<Map<Integer,City>> getWeeklyDates(Integer indexOfCity)throws BaseException;
    SuccessDataResult<Map<Integer,City>> getMonthDates(Integer indexOfCity)throws BaseException;



}
