package org.namazvaxti.prayertimews.core.utilities.messages.error;


import org.namazvaxti.prayertimews.core.utilities.messages.Messages;

/**
 * @author Vugar Mammadli
 */
public enum ErrorMessages implements Messages {
    UNKNOWN("Bilinməyən Xəta. Bir neçə dəqiqə sonra təkrar cəhd edin!"),
    NULL_VALUE("Boş dəyər keçilə bilməz!"),
    INVALID_INDEX("Yanlış şəhər indeksi!"),
    DATA_NOT_FOUND("İstənilən index üzrə məlumat tapılmadı!");

    private final String value;
    ErrorMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
