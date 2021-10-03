package org.namazvaxti.prayertimews.dataAccess.concretes;

import org.namazvaxti.prayertimews.core.utilities.exceptions.DataNotFoundException;
import org.namazvaxti.prayertimews.core.utilities.exceptions.NullValueException;
import org.namazvaxti.prayertimews.core.utilities.messages.error.ErrorMessages;
import org.namazvaxti.prayertimews.dataAccess.abstracts.CheckerCurrentData;
import org.namazvaxti.prayertimews.dataAccess.abstracts.ReadDataFromJson;
import org.namazvaxti.prayertimews.dataAccess.abstracts.TimeRepository;
import org.namazvaxti.prayertimews.entities.concretes.time.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

@Repository
public class TimeRepositoryManager implements TimeRepository {

    public static String DATA_PATH = "src/main/java/org/namazvaxti/prayertimews/dataAccess/data/json/";

    private CheckerCurrentData checkerCurrentData;
    private ReadDataFromJson readDataFromJson;
    private CityBean cityBean;

    @Autowired
    public TimeRepositoryManager(CheckerCurrentData checkerCurrentData, ReadDataFromJson readDataFromJson,CityBean cityBean) {
        this.checkerCurrentData = checkerCurrentData;
        this.readDataFromJson = readDataFromJson;
        this.cityBean = cityBean;
    }

    private JsonStructure getAllData(Integer indexOfCity) throws DataNotFoundException, NullValueException {
        if (indexOfCity == null)throw new NullValueException();
        if(checkerCurrentData.hasDataInLocalRepository(indexOfCity)
                && checkerCurrentData.isCurrentDataInLocalRepository(indexOfCity))
            return readDataFromJson.readAllDataFromLocalRepository(indexOfCity);
        else {
            throw new DataNotFoundException(ErrorMessages.DATA_NOT_FOUND.getValue());
        }
    }

    @Override
    public JsonStructure getAllDataAsJson(Integer indexOfCity) throws DataNotFoundException, NullValueException {
        return getAllData(indexOfCity);
    }

    @Override
    public JsonStructure getListOfCities() {
        try(
                Reader reader = new FileReader("src/main/java/org/namazvaxti/prayertimews/client/helper/ListOfCity.json");
                JsonReader jsonReader = Json.createReader(reader)
        ) {
            return jsonReader.read().asJsonArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CityBean getToDayDates(int idexOfCity) throws DataNotFoundException, NullValueException {
        JsonStructure jsonStructure = getAllData(idexOfCity);
        //cityBean.setDayOfYear(jsonStructure.);
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
