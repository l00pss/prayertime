package org.namazvaxti.prayertimews.dataAccess.concretes;

import org.namazvaxti.prayertimews.dataAccess.abstracts.CheckerCurrentData;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CheckData implements CheckerCurrentData {
    String nowYear = new SimpleDateFormat("yyyy").format(new Date());
    @Override
    public boolean hasDataInLocalRepository(int indexOfCity) {
        return new File(TimeRepositoryManager.DATA_PATH + indexOfCity+".json").exists();
    }

    @Override
    public boolean isCurrentDataInLocalRepository(int indexOfCity) {
        try (Reader fileReader = new FileReader(TimeRepositoryManager.DATA_PATH + indexOfCity+".json");
             JsonReader jsonReader = Json.createReader(fileReader)) {
            JsonObject jsonObject = jsonReader
                    .readObject().get("cityinfo")
                    .asJsonObject().get("vakit").asJsonArray().get(1)
                    .asJsonObject().get("@attributes").asJsonObject();
            String date = jsonObject.getString("tarih").substring(0, 4);
            return date.equalsIgnoreCase(nowYear);
        }catch (IOException exception){
            exception.getStackTrace();
            return false;
        }
    }
}
