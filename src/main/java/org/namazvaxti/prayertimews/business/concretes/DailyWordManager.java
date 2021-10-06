package org.namazvaxti.prayertimews.business.concretes;

import org.namazvaxti.prayertimews.business.abstracts.DailyWordService;
import org.namazvaxti.prayertimews.core.utilities.messages.success.SuccessMessages;
import org.namazvaxti.prayertimews.core.utilities.result.success.SuccessDataResult;
import org.namazvaxti.prayertimews.dataAccess.abstracts.DailyWordRepository;
import org.namazvaxti.prayertimews.entities.concretes.DailyWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyWordManager implements DailyWordService {

    private DailyWordRepository repository;

    @Autowired
    public DailyWordManager(DailyWordRepository repository) {
        this.repository = repository;
    }

    @Override
    public SuccessDataResult<DailyWord> getToDaysWord() {
        return new SuccessDataResult<>(SuccessMessages.OK.getValue());
    }
}
