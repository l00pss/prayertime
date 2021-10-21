package org.namazvaxti.prayertimews.api.advices;

import org.namazvaxti.prayertimews.core.utilities.exceptions.*;
import org.namazvaxti.prayertimews.core.utilities.messages.error.ErrorMessages;
import org.namazvaxti.prayertimews.core.utilities.result.error.ErrorDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {



    @ExceptionHandler(IndexOfCityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> indexOfCityNotFoundException(){
        return new ErrorDataResult<>(ErrorMessages.INVALID_INDEX.getValue());
    }

    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> nullValueException(){
        return new ErrorDataResult<>(ErrorMessages.NULL_VALUE.getValue());
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> dataNotFoundException(){
        return new ErrorDataResult<>(ErrorMessages.DATA_NOT_FOUND.getValue());
    }

    @ExceptionHandler(UnknownException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> unknowException(){
        return new ErrorDataResult<>(ErrorMessages.UNKNOWN.getValue());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> illegalArgumentException(){
        return new ErrorDataResult<>(ErrorMessages.ILLEGAL_ARGUMENT.getValue());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exception){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<>(validationErrors,ErrorMessages.UNKNOWN.getValue());
    }

}
