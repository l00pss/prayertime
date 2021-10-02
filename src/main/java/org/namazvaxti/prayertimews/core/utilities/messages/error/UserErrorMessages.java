package org.namazvaxti.prayertimews.core.utilities.messages.error;


import org.namazvaxti.prayertimews.core.utilities.messages.Messages;

/**
 * @author Vugar Mammadli
 */
public enum UserErrorMessages implements Messages {
    ERROR("Bilinməyən Xəta. Bir neçə dəqiqə sonra təkrar sınayın"),
    NULL_VALUE("Boş dəyər keçilə bilməz"),
    INVALID_CHARACTER("Icazə verilməyən sinvol istifadəsi");

    private final String value;
    UserErrorMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
