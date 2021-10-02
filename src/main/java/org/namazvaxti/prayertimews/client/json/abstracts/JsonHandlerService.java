package org.namazvaxti.prayertimews.client.json.abstracts;

import javax.json.JsonStructure;
import java.io.IOException;
import java.util.Optional;

public interface JsonHandlerService {
    JsonStructure readJsonFromUrl(String URL_PATH) throws IOException;
}
