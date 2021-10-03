package org.namazvaxti.prayertimews.dataAccess.abstracts;

import javax.json.JsonStructure;

public interface ReadDataFromJson {
    JsonStructure readAllDataFromLocalRepository(int indexOfCity);
}
