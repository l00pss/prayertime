package org.namazvaxti.prayertimews.client.abstracts;


import org.namazvaxti.prayertimews.core.utilities.exceptions.IndexOfCityNotFoundException;

import java.util.HashSet;
import java.util.Optional;

public interface CheckCityList {

    Optional<HashSet<Integer>> getListOfCity();

    boolean containCityInList(final int cityOfIndex) throws IndexOfCityNotFoundException;


}
