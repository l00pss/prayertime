package org.namazvaxti.prayertimews.business.abstracts;

import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.entities.concretes.DailyWord;

public interface DailyWordService {
    SuccessDataResult<DailyWord> getToDaysWord();
}
