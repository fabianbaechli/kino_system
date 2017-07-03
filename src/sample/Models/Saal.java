package sample.Models;

import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Saal {
    private UUID id;
    private String anzahlSitzplaetze;
    private String name;
    private String leinwandhoehe;
    private boolean dreidfaehigkeit;

    public Saal(String anzahlSitzplaetze, String name, String leinwandhoehe, boolean dreidfaehigkeit){
        this.id = UUID.randomUUID();
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.name = name;
        this.leinwandhoehe = leinwandhoehe;
        this.dreidfaehigkeit = dreidfaehigkeit;
    }

    public Saal(String id, String anzahlSitzplaetze, String name, String leinwandhoehe, boolean dreidfaehigkeit){
        this.id = UUID.fromString(id);
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.name = name;
        this.leinwandhoehe = leinwandhoehe;
        this.dreidfaehigkeit = dreidfaehigkeit;
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

    public boolean isDreidfaehigkeit() {
        return dreidfaehigkeit;
    }
}
