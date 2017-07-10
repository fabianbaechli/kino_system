package sample.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    private Boolean dreidfaehigkeit;
    public static ObservableList<Sitzplatz> sitzplätze = FXCollections.observableArrayList();


    public Saal(String anzahlSitzplaetze, String name, String leinwandhoehe, Boolean dreidfaehigkeit, String kinoID) {
        this.id = UUID.randomUUID();
        this.anzahlSitzplaetze = anzahlSitzplaetze;
        this.name = name;
        this.leinwandhoehe = leinwandhoehe;
        this.dreidfaehigkeit = dreidfaehigkeit;
        this.kinoID = UUID.fromString(kinoID);
    }

    public Saal(String id, String anzahlSitzplaetze, String name, String leinwandhoehe, String kinoIDs, Boolean dreidfaehigkeit) {
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

    public boolean isDreidfaehigkeit() {
        return dreidfaehigkeit;
    }

    public String getID() {
        return id.toString();
    }
}
