package org.namazvaxti.prayertimews.core.utilities.messages.success;


import org.namazvaxti.prayertimews.core.utilities.messages.Messages;

/**
 * @author Vugar Mammadli
 */
public enum UserSuccessMessages implements Messages {
    SAVE("İstifadəçi uğurla əlavə edildi"),
    FIND_BY_ID("Axtarılan sorğu üzrə nəticə tapıldı"),
    FIND_ALL("Axtarılan sorğu üzrə bütün nəticələr"),
    CONTAIN("Axtarılan sorğu üzrə bir sıra nəticələr"),
    START_WITH("Axtarılan sorğu üzrə bir sıra nəticələr"),
    DELETE("Hesabınız silindi")
    ;
    private final String value;
    UserSuccessMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }




}
