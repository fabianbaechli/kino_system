package sample.JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import sample.Models.Film;
import sample.Sammlungen.FilmeSammlung;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class LoadFromJSON {

    private JsonParser parser;


    public void Load(String path) throws FileNotFoundException {
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
                            jsonObject.get("3dfaehigkeit").getAsString(),
                            jsonObject.get("sprache").getAsString()
                    )
            );

        }
    }
}
