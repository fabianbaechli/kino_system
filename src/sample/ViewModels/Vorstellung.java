package sample.ViewModels;

import sample.Models.Film;
import sample.Models.Saal;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Vorstellung {

    public UUID _vorstellungsID;
    public UUID _saalID;
    public UUID _filmID;
    public Date _date;
    public Time _time;
    public int _preis;

    public Vorstellung(UUID saal, UUID film, String date, String time, int preis) {
        _vorstellungsID = UUID.randomUUID();
        _saalID = saal;
        _filmID = film;
        _date = Date.from(Instant.now());
        _time = Time.valueOf(time);
        _preis = preis;
    }
    public Vorstellung(String VorstellungsID,String saal, String film, String date, String time, int preis) {
        _vorstellungsID = UUID.fromString(VorstellungsID);
        _saalID = UUID.fromString(saal);
        _filmID = UUID.fromString(film);
        _date = Date.from(Instant.now());
        _time = Time.valueOf(time);
        _preis = preis;
    }
}
