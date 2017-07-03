package sample.Models;

import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Saal {
    private UUID id;
    private String anzahlSitzplaetze;
    private String name;
    private UUID kinoID;
    private String leinwandhoehe;
    private String dreidfaehigkeit;

    public Saal(String anzahlSitzplaetze, String name, String leinwandhoehe, String dreidfaehigkeit, String kinoID) {
        this.id = UUID.randomUUID();
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.name = name;
        this.leinwandhoehe = leinwandhoehe;
        this.dreidfaehigkeit = dreidfaehigkeit;
        this.kinoID = UUID.fromString(kinoID);
    }

    public Saal(String id, String anzahlSitzplaetze, String name, String leinwandhoehe, String kinoIDs, String dreidfaehigkeit) {
        this.id = UUID.fromString(id);
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.name = name;
        this.leinwandhoehe = leinwandhoehe;
        this.dreidfaehigkeit = dreidfaehigkeit;
        this.kinoID = UUID.fromString(kinoIDs);
    }

    public UUID getId() {
        return id;
    }

    public String getAnzahlSitzplaetze() {
        return anzahlSitzplaetze;
    }

    public String getName() {
        return name;
    }

    public String getLeinwandhoehe() {
        return leinwandhoehe;
    }

    public String isDreidfaehigkeit() {
        return dreidfaehigkeit;
    }

    public String getID() {
        return id.toString();
    }
}
