package sample.ViewModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.Kino;
import sample.Models.Saal;

/**
 * Created by Fabrice on 19.06.2017.
 */
public class Kinobuchungsystem {

    public static ObservableList<Kino> Kinos = FXCollections.observableArrayList();
    public static ObservableList<Vorstellung> Vorstellungen = FXCollections.observableArrayList();
    public static ObservableList<Saal> saale = FXCollections.observableArrayList();
}
