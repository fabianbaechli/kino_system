package sample.JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.regexp.internal.RE;
import sample.Models.*;
import sample.Sammlungen.FilmeSammlung;
import sample.Sammlungen.PersonenSammelung;
import sample.ViewModels.Kinobuchungsystem;
import sample.ViewModels.ReservationSitzplatz;
import sample.ViewModels.Vorstellung;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */

public class LoadFromJSON {

    private JsonParser parser;
    private String KinoCon = "Kinos.json";
    private String MovieCon = "Movies.json";
    private String PersonCon = "Persons.json";
    private String SaalCon = "Saale.json";
    private String ResSitzCon = "ResSitz.json";
    private String SitzplatzCon = "Sitzplatz.json";
    private String VorstPath = "Vorst.json";
    private String ReservationCon = "Reservation.json";

    public void LoadAll() {
        try {
            LoadKinos(KinoCon);
            LoadMovies(MovieCon);
            LoadSitzplatz(SitzplatzCon);
            LoadPersonen(PersonCon);
            LoadSaal(SaalCon);
            LoadVorstellungen(VorstPath);
            LoadReservationSitzplatz(ResSitzCon);
            LoadReservation(ReservationCon);

        } catch (FileNotFoundException e) {
            //Handle Exception
        }
    }

    public void LoadMovies(String path) throws FileNotFoundException {
        parser = new JsonParser();
        Object obj = parser.parse(new FileReader(path));

        JsonArray Filme = (JsonArray) obj;

        for (JsonElement j : Filme) {
            JsonObject jsonObject = j.getAsJsonObject();
            FilmeSammlung.Filme.add(
                    new Film(
                            jsonObject.get("id").getAsString(),
                            jsonObject.get("name").getAsString(),
                            jsonObject.get("beschreibung").getAsString(),
                            jsonObject.get("dauer").getAsString(),
                            jsonObject.get("altersbegrenzung").getAsString(),
                            jsonObject.get("dreidfaehigkeit").getAsString(),
                            jsonObject.get("sprache").getAsString()
                    )
            );

        }
    }

    public void LoadPersonen(String path) throws FileNotFoundException {
        parser = new JsonParser();
        Object obj = parser.parse(new FileReader(path));

        JsonArray personen = (JsonArray) obj;

        for (JsonElement j : personen) {
            JsonObject jsonObject = j.getAsJsonObject();
            PersonenSammelung.Personen.add(
                    new Person(
                            jsonObject.get("id").getAsString(),
                            jsonObject.get("name").getAsString(),
                            jsonObject.get("vorname").getAsString(),
                            jsonObject.get("email").getAsString(),
                            jsonObject.get("telefonnummer").getAsString()
                    )
            );

        }
    }

    public void LoadSitzplatz(String path) throws FileNotFoundException {
        parser = new JsonParser();
        Object obj = parser.parse(new FileReader(path));

        JsonArray Sitz = (JsonArray) obj;

        for (JsonElement j : Sitz) {
            JsonObject jsonObject = j.getAsJsonObject();
            Saal.sitzplätze.add(
                    new Sitzplatz(
                            jsonObject.get("SaalID").getAsString(),
                            jsonObject.get("platz").getAsString()
                    )
            );

        }
    }

    public void LoadSaal(String path) throws FileNotFoundException {
        parser = new JsonParser();
        String kinoId = "";
        Object obj = parser.parse(new FileReader(path));

        JsonArray saale = (JsonArray) obj;

        for (JsonElement j : saale) {
            JsonObject jsonObject = j.getAsJsonObject();


            for (Kino i : Kinobuchungsystem.Kinos
                    ) {
                if (i.getID() == jsonObject.get("id").getAsString()) {
                    kinoId = i.getID();
                }

                Kinobuchungsystem.saale.add(
                        new Saal(
                                jsonObject.get("id").getAsString(),
                                jsonObject.get("anzahlSitzplaetze").getAsString(),
                                jsonObject.get("name").getAsString(),
                                jsonObject.get("leinwandhoehe").getAsString(),
                                kinoId,
                                jsonObject.get("dreidfaehigkeit").getAsBoolean()
                        )
                );
            }
        }
    }

    public void LoadKinos(String path) throws FileNotFoundException {
        parser = new JsonParser();
        Object obj = parser.parse(new FileReader(path));

        JsonArray kinos = (JsonArray) obj;

        for (JsonElement j : kinos) {
            JsonObject jsonObject = j.getAsJsonObject();
            Kinobuchungsystem.Kinos.add(
                    new Kino(
                            jsonObject.get("id").getAsString(),
                            jsonObject.get("name").getAsString(),
                            jsonObject.get("mitgliedsname").getAsString(),
                            jsonObject.get("email").getAsString(),
                            jsonObject.get("adresse").getAsString()
                    )
            );
        }
    }

    public void LoadVorstellungen(String path) throws FileNotFoundException {
        parser = new JsonParser();
        String saalID = "";
        String filmID = "";
        Object obj = parser.parse(new FileReader(path));

        JsonArray Vorstellungen = (JsonArray) obj;

        for (JsonElement j : Vorstellungen) {
            JsonObject jsonObject = j.getAsJsonObject();


            for (Saal i : Kinobuchungsystem.saale
                    ) {
                if (i.getID() == jsonObject.get("id").getAsString()) {
                    saalID = i.getID();
                }
            }
            for (Film i : FilmeSammlung.Filme
                    ) {
                if (i.getID() == jsonObject.get("id").getAsString()) {
                    filmID = i.getID();
                }
            }
            Kinobuchungsystem.Vorstellungen.add(
                    new Vorstellung(
                            jsonObject.get("_vorstellungsID").getAsString(),
                            saalID,
                            filmID,
                            jsonObject.get("_date").getAsString(),
                            jsonObject.get("_time").getAsString(),
                            jsonObject.get("_preis").getAsInt()
                    )
            );
        }
    }

    public void LoadReservationSitzplatz(String path) throws FileNotFoundException {
        parser = new JsonParser();
        String vostellID = "";
        String sitzplatzID = "";
        Object obj = parser.parse(new FileReader(path));

        JsonArray ResSitz = (JsonArray) obj;

        for (JsonElement j : ResSitz) {
            JsonObject jsonObject = j.getAsJsonObject();


            for (Sitzplatz i : Saal.sitzplätze
                    ) {
                if (i.getID() == jsonObject.get("id").getAsString()) {
                    sitzplatzID = i.getID();
                }
            }
            for (Vorstellung i : Kinobuchungsystem.Vorstellungen
                    ) {
                if (i.getID().toString().equals(jsonObject.get("id").getAsString())) {
                    vostellID = i.getID().toString();
                }
            }
            Kinobuchungsystem.ResSitz.add(
                    new ReservationSitzplatz(
                            jsonObject.get("id").getAsString(),
                            vostellID,
                            sitzplatzID
                    )
            );
        }
    }

    public void LoadReservation(String path) throws FileNotFoundException {
        parser = new JsonParser();
        String personID = "";
        String resSitzID = "";
        Object obj = parser.parse(new FileReader(path));

        JsonArray Reservation = (JsonArray) obj;

        for (JsonElement j : Reservation) {
            JsonObject jsonObject = j.getAsJsonObject();


            for (Person i : PersonenSammelung.Personen
                    ) {
                if (i.getID() == jsonObject.get("id").getAsString()) {
                    personID = i.getID();
                }
            }
            for (ReservationSitzplatz i : Kinobuchungsystem.ResSitz
                    ) {
                if (i.getID() == jsonObject.get("id").getAsString()) {
                    resSitzID = i.getID();
                }
            }
            Kinobuchungsystem.ResSitz.add(
                    new ReservationSitzplatz(
                            jsonObject.get("id").getAsString(),
                            resSitzID,
                            personID
                    )
            );
        }
    }
}
