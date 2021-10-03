package org.namazvaxti.prayertimews.business.abstracts;

import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;

import javax.json.JsonStructure;

public interface TimeService {
    SuccessDataResult<JsonStructure> getAllDataAsJson(int indexOfCity) throws DataNotFoundException;
}
