package sample.ViewModels;

import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class ReservationSitzplatz {

    public UUID id;
    public UUID vorstellungID;
    public UUID sitzplatzID;

    public ReservationSitzplatz(String id,UUID sitzplatz, UUID vorst){
        this.id = UUID.fromString(id);
        vorstellungID = vorst;
        sitzplatzID = sitzplatz;
    }

    public ReservationSitzplatz(String sitzplatz, String vorst){
        this.id = UUID.randomUUID();
        vorstellungID = UUID.fromString(vorst);
        sitzplatzID = UUID.fromString(sitzplatz);
    }

    public UUID getID() {
        return id;
    }
}
