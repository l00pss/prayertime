package org.namazvaxti.prayertimews.api.json;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.core.utilities.exceptions.IndexOfCityNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.core.utilities.messages.error.UserErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/json/1.0/today")
public class TimeControllerToDayAsJson {

    private TimeService timeService;

    @Autowired
    public TimeControllerToDayAsJson(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/dailytime/{indexOfCity}")
    public ResponseEntity<CityBean> getToDayDates(@Param("indexOfCity") int indexOfCity){
        return new ResponseEntity<CityBean>(new CityBean(), HttpStatus.OK);
    }

    public ResponseEntity<List<CityBean>> getWeeklyDates(@Param("indexOfCity") int indexOfCity){
        return new ResponseEntity<List<CityBean>>(new ArrayList<CityBean>(),HttpStatus.OK);
    }



    @ExceptionHandler(IndexOfCityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult indexOfCityNotFoundException(IndexOfCityNotFoundException exception){
        return new ErrorDataResult(UserErrorMessages.INVALID_CHARACTER.getValue());
    }


    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult nullValueException(NullValueException exception){
        return new ErrorDataResult(UserErrorMessages.NULL_VALUE.getValue());
    }


}
