package org.namazvaxti.prayertimews.core.utilities.result.error;


import org.namazvaxti.prayertimews.core.utilities.result.Result;

public class ErrorResult extends Result {
    public ErrorResult(){
        super(false);
    }
    public ErrorResult(String message){
        super(false,message);
    }
}
