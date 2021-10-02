package org.namazvaxti.prayertimews.core.utilities.result.success;

import org.namazvaxti.prayertimews.core.utilities.result.DataResult;

/**
 * @author Vugar Mammadli
 */
public class SuccessDataResult<T> extends DataResult {

    public SuccessDataResult(T data,String message) {
        super(data, true, message);
    }

    public SuccessDataResult(T data){
        super(true,data);
    }

    public SuccessDataResult(String message){
        super(null,true,message);
    }

    public SuccessDataResult(){
        super(true,null);
    }

}
