package org.namazvaxti.prayertimews.core.utilities.result.error;


import org.namazvaxti.prayertimews.core.utilities.result.DataResult;

public class ErrorDataResult<T> extends DataResult {
    public ErrorDataResult(T data,String message) {
        super(data, false, message);
    }

    public ErrorDataResult(T data,String message,Exception exception) {
        super(data, false, message);
    }
    public ErrorDataResult(T data){
        super(false,data);
    }

    public ErrorDataResult(String message){
        super(null,false,message);
    }

    public ErrorDataResult(){
        super(false,null);
    }
}
