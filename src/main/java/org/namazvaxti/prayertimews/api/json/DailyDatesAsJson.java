package org.namazvaxti.prayertimews.api.json;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.client.abstracts.ClientServer;
import org.namazvaxti.prayertimews.core.utilities.exceptions.*;
import org.namazvaxti.prayertimews.core.utilities.messages.error.ErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.DataResult;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.json.JsonStructure;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

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
        //clientServer.writerToLocalRepository();
    }

    @GetMapping("/citylist")
    public ResponseEntity<DataResult> getListOfCities() throws BaseException {
        return new ResponseEntity<DataResult>(this.timeService.getListOfCities(),HttpStatus.ACCEPTED);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/allDataAsJson/{indexOfCity}")
    public ResponseEntity<DataResult<JsonStructure>> getAllDataAsJson(@Param("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<JsonStructure>>(timeService.getAllDataAsJson(indexOfCity), HttpStatus.OK);
    }


    @GetMapping("/todaydate/{indexOfCity}")
    public ResponseEntity<CityBean> getDatesOfToDay(@Param("indexOfCity") Integer indexOfCity){
        return new ResponseEntity<CityBean>(HttpStatus.OK);
    }

    @PostMapping("/todaydate")
    public ResponseEntity<Object> getDatesOfCurrentDay(@RequestParam("indexOfCity") Integer indexOfCity,
                                                       @RequestParam("date") @DateTimeFormat(pattern = "MM-dd-yyyy") LocalDate date){
        return new ResponseEntity<>(date,HttpStatus.OK);
    }

    @GetMapping("/weeklydates/{indexOfCity}")
    public ResponseEntity<List<CityBean>> getWeeklyDates(@Param("indexOfCity") Integer indexOfCity){
        return new ResponseEntity<List<CityBean>>(new ArrayList<CityBean>(),HttpStatus.OK);
    }


    @ExceptionHandler(IndexOfCityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> indexOfCityNotFoundException(IndexOfCityNotFoundException exception){
        return new ErrorDataResult<Object>(ErrorMessages.INVALID_INDEX.getValue());
    }

    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> nullValueException(NullValueException exception){
        return new ErrorDataResult<Object>(ErrorMessages.NULL_VALUE.getValue());
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> dataNotFoundException(DataNotFoundException exception){
        return new ErrorDataResult<Object>(ErrorMessages.DATA_NOT_FOUND.getValue());
    }

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> unknowException(UnknownException exception){
        return new ErrorDataResult<Object>(ErrorMessages.UNKNOWN.getValue());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(validationErrors,ErrorMessages.UNKNOWN.getValue());
    }

}
