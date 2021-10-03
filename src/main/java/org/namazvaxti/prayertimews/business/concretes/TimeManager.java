package org.namazvaxti.prayertimews.business.concretes;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.UnknownException;
import org.namazvaxti.prayertimews.core.utilities.messages.success.SuccessMessages;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.dataAccess.abstracts.TimeRepository;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonStructure;
import java.util.List;

@Service
public class TimeManager implements TimeService {


    private TimeRepository timeRepository;

    @Autowired
    public TimeManager(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }


    @Override
    public SuccessDataResult<JsonStructure> getAllDataAsJson(Integer indexOfCity) throws DataNotFoundException, NullValueException {
        return new SuccessDataResult<>(this.timeRepository.getAllDataAsJson(indexOfCity), SuccessMessages.FIND_BY_INDEX.getValue());
    }

    @Override
    public SuccessDataResult<JsonStructure> getListOfCities() throws UnknownException {
        JsonStructure jsonStructure = this.timeRepository.getListOfCities();
        if(jsonStructure==null) throw new UnknownException();
        return new SuccessDataResult<>(jsonStructure, SuccessMessages.OK.getValue());
    }

    @Override
    public SuccessDataResult<CityBean> getToDayDates(Integer indexOfCity) {
        return null;
    }

    @Override
    public SuccessDataResult<List<CityBean>> getWeeklyDates(Integer indexOfCity) {
        return null;
    }

    @Override
    public SuccessDataResult<List<CityBean>> getMonthDates(Integer indexOfCity) {
        return null;
    }


}
