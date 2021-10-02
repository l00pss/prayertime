package org.namazvaxti.prayertimews.client.json.abstracts;

import javax.json.JsonStructure;
import java.io.IOException;
import java.util.Optional;

public interface JsonHandlerService {
    Optional<JsonStructure> readJsonFromUrl() throws IOException;
}
