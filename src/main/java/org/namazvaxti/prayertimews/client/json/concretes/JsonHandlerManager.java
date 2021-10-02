package org.namazvaxti.prayertimews.client.json.concretes;

import org.namazvaxti.prayertimews.client.json.abstracts.JsonHandlerService;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonStructure;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Component
public class JsonHandlerManager implements JsonHandlerService {

    @Override
    public JsonStructure readJsonFromUrl(String URL_PATH) throws IOException {
        try(InputStream inputStream = new URL(URL_PATH).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
        ) {
            return Json.createReader(bufferedReader).readObject();
        }catch (IOException exception){
            exception.getStackTrace();
            return null;
        }
    }

}
