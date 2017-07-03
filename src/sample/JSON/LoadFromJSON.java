package sample.JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sample.Models.Film;
import sample.Models.Kino;
import sample.Models.Person;
import sample.Models.Saal;
import sample.Sammlungen.FilmeSammlung;
import sample.Sammlungen.PersonenSammelung;
import sample.ViewModels.Kinobuchungsystem;
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
    private String VorstPath = "Vorst.json";

    public void LoadAll() {
        try {
            LoadKinos(KinoCon);
            LoadMovies(MovieCon);
            LoadPersonen(PersonCon);
            LoadSaal(SaalCon);
            LoadVorstellungen(VorstPath);
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
            }
            Kinobuchungsystem.saale.add(
                    new Saal(
                            jsonObject.get("id").getAsString(),
                            jsonObject.get("anzahlSitzplaetze").getAsString(),
                            jsonObject.get("name").getAsString(),
                            jsonObject.get("leinwandhoehe").getAsString(),
                            kinoId,
                            jsonObject.get("dreidfaehigkeit").getAsString()
                    )
            );
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
}
