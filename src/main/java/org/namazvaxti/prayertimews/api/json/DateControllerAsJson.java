package org.namazvaxti.prayertimews.api.json;

import io.swagger.models.auth.In;
import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.client.abstracts.ClientServer;
import org.namazvaxti.prayertimews.core.utilities.exceptions.*;
import org.namazvaxti.prayertimews.core.utilities.messages.error.ErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.DataResult;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.namazvaxti.prayertimews.entities.concretes.CityBean;
import org.namazvaxti.prayertimews.entities.concretes.time.City;
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
@RequestMapping("api/dates/json/1.0")
public class DateControllerAsJson {

    private TimeService timeService;
    private ClientServer clientServer;

    @Autowired
    public DateControllerAsJson(ClientServer clientServer , TimeService timeService) {
        this.clientServer = clientServer;
        this.timeService = timeService;
    }

    @PostConstruct
    public void initClientServer() throws IOException {
        //clientServer.writerToLocalRepository();
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/citylist")
    public ResponseEntity<DataResult<List<CityBean>>> getListOfCities() throws BaseException {
        return new ResponseEntity<DataResult<List<CityBean>>>(this.timeService.getListOfCities(),HttpStatus.ACCEPTED);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/allDataYearly")
    public ResponseEntity<DataResult<Map<Integer,City>>> getAllDataYearly(@RequestParam("indexOfCity") Integer indexOfCity) throws BaseException, CloneNotSupportedException {
        return new ResponseEntity<DataResult<Map<Integer,City>>>(timeService.getAllDataAsYearly(indexOfCity), HttpStatus.OK);
    }


    @SuppressWarnings("unchecked")
    @GetMapping("/todaydate/{indexOfCity}")
    public ResponseEntity<DataResult<City>> getDatesOfToDay(@Param("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<City>>(this.timeService.getDatesOfDay(indexOfCity),HttpStatus.OK);
    }

    @PostMapping("/currentdate")
    public ResponseEntity<DataResult<City>> getDatesOfCurrentDay(@RequestParam("indexOfCity") Integer indexOfCity,
                                                                 @RequestParam("date") @DateTimeFormat(pattern = "MM-dd-yyyy") LocalDate date){
        return new ResponseEntity<DataResult<City>>(HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/weeklydates/{indexOfCity}")
    public ResponseEntity<DataResult<Map<Integer,City>>> getWeeklyDates(@Param("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<Map<Integer,City>>>(this.timeService.getWeeklyDates(indexOfCity),HttpStatus.OK);
    }


    @GetMapping("/monthlydates/{indexOfCity}")
    public ResponseEntity<DataResult<Map<Integer,City>>> getMonthlyDates(@Param("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<Map<Integer,City>>>(this.timeService.getMonthDates(indexOfCity),HttpStatus.OK);
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
