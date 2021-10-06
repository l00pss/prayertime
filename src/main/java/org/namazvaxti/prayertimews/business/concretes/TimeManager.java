package org.namazvaxti.prayertimews.business.concretes;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.core.utilities.exceptions.BaseException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.UnknownException;
import org.namazvaxti.prayertimews.core.utilities.messages.success.SuccessMessages;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.dataAccess.abstracts.TimeRepository;
import org.namazvaxti.prayertimews.entities.concretes.CityBean;
import org.namazvaxti.prayertimews.entities.concretes.time.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TimeManager implements TimeService {


    private TimeRepository timeRepository;

    @Autowired
    public TimeManager(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }


    @Override
    public SuccessDataResult<Map<Integer,City>>getAllDataAsYearly(Integer indexOfCity) throws BaseException, CloneNotSupportedException {
        return new SuccessDataResult<Map<Integer,City>>(this.timeRepository.getAllDataAsYearly(indexOfCity), SuccessMessages.FIND_BY_INDEX.getValue());
    }

    @Override
    public SuccessDataResult<List<CityBean>> getListOfCities() throws BaseException {
        List<CityBean> listOfCities = this.timeRepository.getListOfCities();
        if(listOfCities==null) throw new UnknownException();
        return new SuccessDataResult<List<CityBean>>(listOfCities, SuccessMessages.OK.getValue());
    }

    @Override
    public SuccessDataResult<City> getDatesOfDay(Integer indexOfCity) throws BaseException{
        return new SuccessDataResult<>(this.timeRepository.getDatesOfDay(indexOfCity),SuccessMessages.OK.getValue());
    }

    @Override
    public SuccessDataResult<City> getDatesOfDay(Integer idexOfCity, Date date) throws BaseException {

        return null;
    }

    @Override
    public SuccessDataResult<Map<Integer,City>> getWeeklyDates(Integer indexOfCity) throws BaseException {
        return new SuccessDataResult<>(this.timeRepository.getWeeklyDates(indexOfCity),SuccessMessages.FIND_BY_INDEX.getValue());
    }

    @Override
    public SuccessDataResult<Map<Integer,City>> getMonthDates(Integer indexOfCity) throws BaseException {
        return new SuccessDataResult<>(this.timeRepository.getMonthlyDates(indexOfCity),SuccessMessages.FIND_BY_INDEX.getValue());
    }


}
