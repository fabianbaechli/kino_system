package sample.Models;

import java.util.UUID;

/**
 * Created by Fabrice on 03.07.2017.
 */
public class Sitzplätze {
    UUID SaalID;
    UUID id;

    public Sitzplätze(String saal){
        id = UUID.randomUUID();
        SaalID = UUID.fromString(saal);
    }
    public Sitzplätze(String saal,String id){
        this.id = UUID.fromString(id);
        SaalID = UUID.fromString(saal);
    }
}
