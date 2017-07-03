package sample.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sample.Sammlungen.FilmeSammlung;
import sample.Sammlungen.PersonenSammelung;
import sample.ViewModels.Kinobuchungsystem;
import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class SaveToJSOn {

    private String KinoCon = "Kinos.json";
    private String MovieCon = "Movies.json";
    private String PersonCon = "Persons.json";
    private String SaalCon = "Saale.json";
    private String VorstCon = "Vorst.json";

    public void SaveAll(){
       SaveMovies(MovieCon);
       SavePersonen(PersonCon);
       SaveSaale(SaalCon);
       SaveKino(KinoCon);
        SaveVorstellung(VorstCon);
    }

    public void SaveMovies(String path) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(FilmeSammlung.Filme, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }
    public void SavePersonen(String path) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(PersonenSammelung.Personen, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }
    public void SaveSaale(String path) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(Kinobuchungsystem.saale, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }

    public void SaveKino(String path) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(Kinobuchungsystem.Kinos, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }

    public void SaveVorstellung(String path) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(Kinobuchungsystem.Vorstellungen, writer);
        }
        catch (Exception ex) {
            System.out.println("Didnt write to JSON");
        }
    }
}
