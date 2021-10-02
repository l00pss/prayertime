package org.namazvaxti.prayertimews.core.utilities.result.success;

import org.namazvaxti.prayertimews.core.utilities.result.Result;

/**
 * @author Vugar Mammadli
 */
public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true,message);
    }
}
