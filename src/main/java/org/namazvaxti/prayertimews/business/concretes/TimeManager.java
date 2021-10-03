package org.namazvaxti.prayertimews.business.concretes;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.UnknowException;
import org.namazvaxti.prayertimews.core.utilities.messages.success.UserSuccessMessages;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.dataAccess.abstracts.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonStructure;

@Service
public class TimeManager implements TimeService {


    private TimeRepository timeRepository;

    @Autowired
    public TimeManager(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }


    @Override
    public SuccessDataResult<JsonStructure> getAllDataAsJson(Integer indexOfCity) throws DataNotFoundException, NullValueException {
        return new SuccessDataResult<>(this.timeRepository.getAllDataAsJson(indexOfCity), UserSuccessMessages.FIND_BY_ID.getValue());
    }

    @Override
    public SuccessDataResult<JsonStructure> getListOfCities() throws UnknowException {
        JsonStructure jsonStructure = this.timeRepository.getListOfCities();
        if(jsonStructure==null) throw new UnknowException();
        return new SuccessDataResult<>(jsonStructure,UserSuccessMessages.SAVE.getValue());
    }


}
