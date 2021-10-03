package org.namazvaxti.prayertimews.client.concretes;

import org.namazvaxti.prayertimews.client.abstracts.CheckCityList;
import org.namazvaxti.prayertimews.client.abstracts.ClientServer;
import org.namazvaxti.prayertimews.client.json.abstracts.JsonHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@Component
public class ClientManager implements ClientServer {

    private static String URL_ADDRESS = "https://www.turktakvim.com/XMLservis.php?tip=vakit&cityID=CCCC&format=json";
    private  static String DATA_PATH = "src/main/java/org/namazvaxti/prayertimews/dataAccess/data/json/";

    private JsonHandlerService jsonHandlerService;
    private CheckCityList checkCityList;



    @Autowired
    public ClientManager(JsonHandlerService jsonHandlerService, CheckCityList checkCityList) {
        this.jsonHandlerService = jsonHandlerService;
        this.checkCityList = checkCityList;
    }


    private Map<Integer,String> urlPathListener(){
        Map<Integer,String> listOfPath = new HashMap<>();
        Iterator<Integer> iterator = checkCityList.getListOfCity().iterator();
        int index;
        while (iterator.hasNext()){
            index = iterator.next();
            listOfPath.putIfAbsent(index, String.valueOf(index));
        }
        return listOfPath;
    }

    @Override
    public void writerToLocalRepository() throws IOException {
        for (Map.Entry<Integer,String> entry : urlPathListener().entrySet()){
            String path = entry.getValue();
            JsonStructure jsonStructure = jsonHandlerService.readJsonFromUrl(URL_ADDRESS.replace("CCCC", path));
            writerJson(jsonStructure,DATA_PATH + path + ".json");
            System.err.println("Yüklənir... "+entry.getKey());
        }
    }

    public void writerJson(JsonStructure optionalJsonStructure,String path){
            Map<String,Boolean> config = Map.ofEntries(Map.entry(JsonGenerator.PRETTY_PRINTING,true));
            try(
                    FileWriter fileWriter = new FileWriter(path);
                    JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(fileWriter)
            )
            {
                    jsonWriter.writeObject((JsonObject) optionalJsonStructure);

            } catch (IOException exception) {
                exception.printStackTrace();
            }
    }


}
