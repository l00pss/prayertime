package org.namazvaxti.prayertimews.api.json;


import org.namazvaxti.prayertimews.business.abstracts.DailyWordService;
import org.namazvaxti.prayertimews.core.utilities.messages.error.ErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.DataResult;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dailyword/json/1.0")
public class DailyWordControllerAsJson {

    private DailyWordService service;

    @Autowired
    public DailyWordControllerAsJson(DailyWordService service) {
        this.service = service;
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/todaysword")
    public ResponseEntity<DataResult<String >> getToDaysWord(){
        return new ResponseEntity<DataResult<String>>(this.service.getToDaysWord(),HttpStatus.OK);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult unknownException(MethodArgumentNotValidException exception){
        return new ErrorDataResult(ErrorMessages.UNKNOWN.getValue());
    }
}
