package sample.Models;

import java.util.UUID;

/**
 * Created by Fabrice on 10.07.2017.
 */
public class Sitzplatz {
    private UUID SaalID;
    private String platz;


    public Sitzplatz(String saalID, String platz) {
        SaalID = UUID.fromString(saalID);
        this.platz = platz;
    }

    public String getID() {
        return SaalID.toString();
    }
}
