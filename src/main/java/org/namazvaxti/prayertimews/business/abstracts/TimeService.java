package org.namazvaxti.prayertimews.business.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.entities.concretes.CityBean;
import org.namazvaxti.prayertimews.entities.concretes.time.City;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;

public interface TimeService {

    SuccessDataResult<JsonStructure> getAllDataAsJson(Integer indexOfCity) throws BaseException;
    SuccessDataResult<List<CityBean>> getListOfCities() throws BaseException;

    SuccessDataResult<City> getDatesOfDay(Integer indexOfCity)throws BaseException;
    SuccessDataResult<City> getDatesOfDay(Integer idexOfCity, Date date) throws BaseException;

    SuccessDataResult<List<City>> getWeeklyDates(Integer indexOfCity)throws BaseException;
    SuccessDataResult<List<City>> getMonthDates(Integer indexOfCity)throws BaseException;



}
