package org.namazvaxti.prayertimews.dataAccess.concretes;

import org.namazvaxti.prayertimews.dataAccess.abstracts.ReadDataFromJson;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Component
public class ReadData implements ReadDataFromJson {

    @Override
    public JsonStructure readAllDataFromLocalRepository(int indexOfCity) {
        try(
                Reader reader = new FileReader(TimeRepositoryManager.DATA_PATH + indexOfCity +".json");
                JsonReader jsonReader = Json.createReader(reader)
        ) {
            return jsonReader.readObject().get("cityinfo").asJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
