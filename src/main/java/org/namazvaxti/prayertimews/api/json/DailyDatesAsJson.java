package org.namazvaxti.prayertimews.api.json;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.client.abstracts.ClientServer;
import org.namazvaxti.prayertimews.client.concretes.ClientManager;
import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.IndexOfCityNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.core.utilities.messages.error.UserErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.DataResult;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.json.JsonStructure;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/json/1.0/today")
public class DailyDatesAsJson {

    private TimeService timeService;
    private ClientServer clientServer;

    @Autowired
    public DailyDatesAsJson(ClientServer clientServer ,TimeService timeService) {
        this.clientServer = clientServer;
        this.timeService = timeService;
    }

    @PostConstruct
    public void initClientServer() throws IOException {
        clientServer.writerToLocalRepository();
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/dailytime/{indexOfCity}")
    public ResponseEntity<DataResult<JsonStructure>> getAllDataAsJson(@Param("indexOfCity") int indexOfCity) throws DataNotFoundException {
        return new ResponseEntity<DataResult<JsonStructure>>(timeService.getAllDataAsJson(indexOfCity), HttpStatus.OK);
    }

    public ResponseEntity<List<CityBean>> getWeeklyDates(@Param("indexOfCity") int indexOfCity){
        return new ResponseEntity<List<CityBean>>(new ArrayList<CityBean>(),HttpStatus.OK);
    }



    @ExceptionHandler(IndexOfCityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult indexOfCityNotFoundException(IndexOfCityNotFoundException exception){
        return new ErrorDataResult(UserErrorMessages.INVALID_INDEX.getValue());
    }


    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult nullValueException(NullValueException exception){
        return new ErrorDataResult(UserErrorMessages.NULL_VALUE.getValue());
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult dataNotFoundException(DataNotFoundException exception){
        return new ErrorDataResult(UserErrorMessages.DATA_NOT_FOUND.getValue());
    }


}
