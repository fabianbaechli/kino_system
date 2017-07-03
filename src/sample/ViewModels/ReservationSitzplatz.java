package sample.ViewModels;

import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class ReservationSitzplatz {

    UUID id;
    UUID vorstellungID;
    UUID sitzplatzID;

    public ReservationSitzplatz(String id,String sitzplatz, String vorst){
        this.id = UUID.fromString(id);
        vorstellungID = UUID.fromString(vorst);
        sitzplatzID = UUID.fromString(sitzplatz);
    }

    public ReservationSitzplatz(String sitzplatz, String vorst){
        this.id = UUID.randomUUID();
        vorstellungID = UUID.fromString(vorst);
        sitzplatzID = UUID.fromString(sitzplatz);
    }
}
