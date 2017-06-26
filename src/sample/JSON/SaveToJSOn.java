package sample.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sample.Models.Kino;
import sample.Sammlungen.FilmeSammlung;
import sample.Sammlungen.PersonenSammelung;

import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class SaveToJSOn {

    public static void SaveMovies() {
        try (Writer writer = new FileWriter("Movies.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(FilmeSammlung.Filme, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }
    public static void SavePersonen() {
        try (Writer writer = new FileWriter("Personen.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(PersonenSammelung.Personen, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }
    public static void SaveSaale() {
        try (Writer writer = new FileWriter("Saale.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(Kino.saale, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }
}
