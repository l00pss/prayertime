package org.namazvaxti.prayertimews.dataAccess.concretes;

import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.messages.error.UserErrorMessages;
import org.namazvaxti.prayertimews.dataAccess.abstracts.CheckerCurrentData;
import org.namazvaxti.prayertimews.dataAccess.abstracts.ReadDataFromJson;
import org.namazvaxti.prayertimews.dataAccess.abstracts.TimeRepository;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.json.JsonStructure;
import java.util.Date;
import java.util.List;

@Repository
public class TimeRepositoryManager implements TimeRepository {

    public static String DATA_PATH = "src/main/java/org/namazvaxti/prayertimews/dataAccess/data/json/";

    private CheckerCurrentData checkerCurrentData;
    private ReadDataFromJson readDataFromJson;

    @Autowired
    public TimeRepositoryManager(CheckerCurrentData checkerCurrentData, ReadDataFromJson readDataFromJson) {
        this.checkerCurrentData = checkerCurrentData;
        this.readDataFromJson = readDataFromJson;
    }

    private JsonStructure getAllData(int indexOfCity) throws DataNotFoundException {
        if(checkerCurrentData.hasDataInLocalRepository(indexOfCity)
                && checkerCurrentData.isCurrentDataInLocalRepository(indexOfCity))
            return readDataFromJson.readAllDataFromLocalRepository(indexOfCity);
        else {
            throw new DataNotFoundException(UserErrorMessages.DATA_NOT_FOUND.getValue());
        }
    }

    @Override
    public CityBean getToDayDates(int idexOfCity) throws DataNotFoundException {
        JsonStructure jsonStructure = getAllData(idexOfCity);

        return null;
    }

    @Override
    public CityBean getChangeDayDates(int idexOfCity, Date date) {
        return null;
    }

    @Override
    public List<CityBean> getWeeklyDates(int idexOfCity) {
        return null;
    }

    @Override
    public List<CityBean> getMonthlyDates(int idexOfCity) {
        return null;
    }
}
