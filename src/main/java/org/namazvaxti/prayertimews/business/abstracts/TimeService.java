package org.namazvaxti.prayertimews.business.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.UnknownException;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;

import javax.json.JsonStructure;
import java.util.List;

public interface TimeService {

    SuccessDataResult<JsonStructure> getAllDataAsJson(Integer indexOfCity) throws BaseException;
    SuccessDataResult<JsonStructure> getListOfCities() throws UnknownException;
    SuccessDataResult<CityBean> getToDayDates(Integer indexOfCity);
    SuccessDataResult<List<CityBean>> getWeeklyDates(Integer indexOfCity);
    SuccessDataResult<List<CityBean>> getMonthDates(Integer indexOfCity);


}
