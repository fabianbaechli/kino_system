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

    public UUID id;
    public UUID _saalID;
    public UUID _filmID;
    public Date _date;
    public Time _time;
    public int _preis;

    public Vorstellung(UUID saal, UUID film, String date, String time, int preis) {
        id = UUID.randomUUID();
        _saalID = saal;
        _filmID = film;
        _date = Date.from(Instant.now());
        _time = new Time(System.currentTimeMillis());
        _preis = preis;
    }
    public Vorstellung(String VorstellungsID,UUID saal, UUID film, String date, String time, int preis) {
        id = UUID.fromString(VorstellungsID);
        _saalID = saal;
        _filmID = film;
        _date = Date.from(Instant.now());
        _time = Time.valueOf(time);
        _preis = preis;
    }

    public UUID getID() {
        return id;
    }
    @Override
    public String toString(){
        return Integer.toString(_preis);
    }
}
