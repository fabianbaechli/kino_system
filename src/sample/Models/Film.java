package sample.Models;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Film {

    private String id;
    private String name;
    private String beschreibung;
    private String dauer;
    private String altersbegrenzung;
    private String dreidfaehigkeit;
    private String sprache;

    public Film(String id, String name, String beschreibung, String dauer, String altersbegrenzung, String dreidfaehigkeit, String sprache) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.dauer = dauer;
        this.altersbegrenzung = altersbegrenzung;
        this.dreidfaehigkeit = dreidfaehigkeit;
        this.sprache = sprache;
    }
}
