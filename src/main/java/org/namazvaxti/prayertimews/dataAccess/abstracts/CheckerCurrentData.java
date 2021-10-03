package org.namazvaxti.prayertimews.dataAccess.abstracts;

public interface CheckerCurrentData {

    boolean hasDataInLocalRepository(int indexOfCity);
    boolean isCurrentDataInLocalRepository(int idexOfCity);
}
