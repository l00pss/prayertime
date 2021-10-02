package org.namazvaxti.prayertimews.client.concretes;

import org.namazvaxti.prayertimews.client.abstracts.CheckCityList;
import org.namazvaxti.prayertimews.core.utilities.exceptions.IndexOfCityNotFoundException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Optional;

class CheckCityListManager implements CheckCityList {


    @Override
    public Optional<HashSet<Integer>> getListOfCity() {
        HashSet<Integer> hashSet = new HashSet<>();
        try (JsonReader jsonReader = Json.createReader(new FileReader("src/main/java/org/namazvaxti/prayertimews/client/helper/ListOfCity.json"))
        ){
            JsonArray jsonValues = jsonReader.read().asJsonArray();
            for (int i = 0;i < 56;i++)
                hashSet.add(jsonValues.get(i).asJsonObject().getInt("id"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(hashSet);
    }

    @Override
    public boolean containCityInList(int cityOfIndex) throws IndexOfCityNotFoundException {
        if (getListOfCity().isPresent()){
            Integer index = getListOfCity().get()
                    .stream()
                    .filter(integer -> cityOfIndex == integer)
                    .findAny()
                    .orElseThrow(IndexOfCityNotFoundException::new);
            return index != null;
        }else
            return false;
    }


}
