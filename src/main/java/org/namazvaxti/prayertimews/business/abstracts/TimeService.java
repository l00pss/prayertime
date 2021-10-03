package org.namazvaxti.prayertimews.business.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;

public interface TimeService {

    SuccessDataResult<JsonStructure> getAllDataAsJson(Integer indexOfCity) throws BaseException;
    SuccessDataResult<JsonStructure> getListOfCities() throws BaseException;

    SuccessDataResult<CityBean> getDatesOfDay(Integer indexOfCity)throws BaseException;
    SuccessDataResult<CityBean> getDatesOfDay(Integer idexOfCity, Date date) throws BaseException;

    SuccessDataResult<List<CityBean>> getWeeklyDates(Integer indexOfCity)throws BaseException;
    SuccessDataResult<List<CityBean>> getMonthDates(Integer indexOfCity)throws BaseException;



}
