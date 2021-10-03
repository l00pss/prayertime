package org.namazvaxti.prayertimews.core.utilities.messages.success;


import org.namazvaxti.prayertimews.core.utilities.messages.Messages;

/**
 * @author Vugar Mammadli
 */
public enum SuccessMessages implements Messages {
    OK("İstək təsdiqləndi"),
    FIND_BY_INDEX("Axtarılan sorğu üzrə nəticə tapıldı"),
    RESULT("Axtarılan sorğu üzrə bütün nəticələr")
    ;
    private final String value;
    SuccessMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }




}
