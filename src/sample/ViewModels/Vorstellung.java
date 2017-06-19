package sample.ViewModels;

import sample.Models.Film;
import sample.Models.Saal;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Vorstellung {

    public Saal _saal;
    public Film _film;
    public Date _date;
    public Time _time;
    public int _preis;

    public Vorstellung(Saal saal, Film film, Date date, Time time, int preis) {
        _saal = saal;
        _film = film;
        _date = date;
        _time = time;
        _preis = preis;
    }
}
