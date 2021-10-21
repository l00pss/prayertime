package org.namazvaxti.prayertimews.api.json;

import org.namazvaxti.prayertimews.business.abstracts.TimeService;
import org.namazvaxti.prayertimews.client.abstracts.ClientServer;
import org.namazvaxti.prayertimews.core.utilities.exceptions.*;
import org.namazvaxti.prayertimews.core.utilities.messages.error.ErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.DataResult;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.namazvaxti.prayertimews.entities.concretes.CityBean;
import org.namazvaxti.prayertimews.entities.concretes.time.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("api/dates/json/1.0")
public class DateControllerAsJson {

    private final TimeService timeService;
    private final ClientServer clientServer;

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
    @GetMapping("/todaydate/")
    public ResponseEntity<DataResult<City>> getDatesOfToDay(@RequestParam("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<City>>(this.timeService.getDatesOfDay(indexOfCity),HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/currentdate")
    public ResponseEntity<DataResult<City>> getDatesOfCurrentDay(@RequestParam("indexOfCity") Integer indexOfCity,
                                                                 @RequestParam("date") @DateTimeFormat(pattern = "MM-dd-yyyy") LocalDate date) throws BaseException {
        return new ResponseEntity<DataResult<City>>(this.timeService.getDatesOfDay(indexOfCity,date),HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/weeklydates/")
    public ResponseEntity<DataResult<Map<Integer,City>>> getWeeklyDates(@RequestParam("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<Map<Integer,City>>>(this.timeService.getWeeklyDates(indexOfCity),HttpStatus.OK);
    }


    @SuppressWarnings("unchecked")
    @GetMapping("/monthlydates/")
    public ResponseEntity<DataResult<Map<Integer,City>>> getMonthlyDates(@RequestParam("indexOfCity") Integer indexOfCity) throws BaseException {
        return new ResponseEntity<DataResult<Map<Integer,City>>>(this.timeService.getMonthDates(indexOfCity),HttpStatus.OK);
    }


}
