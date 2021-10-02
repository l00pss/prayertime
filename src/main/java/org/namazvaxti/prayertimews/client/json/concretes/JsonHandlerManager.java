package org.namazvaxti.prayertimews.client.json.concretes;

import org.namazvaxti.prayertimews.client.json.abstracts.JsonHandlerService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonStructure;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;

public class JsonHandlerManager implements JsonHandlerService {
    private int cityIndex;
    private String URL_PATH;

    @Override
    public Optional<JsonStructure> readJsonFromUrl() throws IOException {
        try(InputStream inputStream = new URL(URL_PATH).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
        ) {
            return Optional.of(Json.createReader(bufferedReader).readObject());
        }catch (IOException exception){
            exception.getStackTrace();
            return Optional.empty();
        }
    }

}
