package sample.Controllers;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import sample.Models.Film;
import sample.Models.Kino;
import sample.Models.Person;
import sample.Models.Sitzplatz;
import sample.Sammlungen.FilmeSammlung;
import sample.Sammlungen.PersonenSammelung;
import sample.ViewModels.Kinobuchungsystem;
import sample.ViewModels.Reservation;
import sample.ViewModels.ReservationSitzplatz;
import sample.ViewModels.Vorstellung;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class ShowReservationsController implements Initializable {
    @FXML
    JFXListView<GridPane> entries;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Reservation reservation : Kinobuchungsystem.Reservation){

            Person person = null;
            ReservationSitzplatz reservationSitzplatz = null;
            Vorstellung vorstellung = null;
            Film film = null;

            for (Person pers : PersonenSammelung.Personen){

                if(pers.getID().equals(reservation._personID)){
                    person = pers;
                }
            }

            for (ReservationSitzplatz resSitz  : Kinobuchungsystem.ResSitz) {

                if(resSitz.getID().equals(reservation._reservationsSitzplatzID)){
                    reservationSitzplatz = resSitz;
                }

            }

            if (person != null && reservationSitzplatz != null){

                for (Vorstellung vorst : Kinobuchungsystem.Vorstellungen){

                    if(vorst.id.equals(reservationSitzplatz.vorstellungID)){
                        vorst = vorstellung;
                    }
                }

                if(vorstellung != null){

                    for(Film f : FilmeSammlung.Filme){

                        if(f.getID().equals(vorstellung._filmID)){

                            film = f;
                        }
                    }

                    if(film != null){
                        addEntry(person.vorname + " " + person.name, person.getID().toString(), film.getName(), film.getID().toString(), vorstellung._date.toString());
                    }

                }

            }
        }
        addEntry("Fabian Bächli", "e510acb3-bded-4d98-864e-41ef2a93ca0", "WOW", "0565b2db-1b90-4563-a928-dfa5491bf7e0", "15:15");
    }

    private void addEntry(String personName, String personId, String filmName, String filmId, String zeit) {
        StackPane pane = null;
        try {
            pane = FXMLLoader.load(MainWindowController.class.getResource("../Views/ReservationEntry.fxml"));
            GridPane gridPane = (GridPane) pane.getChildren().get(0);

            gridPane.add(new Label(personName), 0, 0);
            gridPane.add(new Label(personId), 1, 0);
            gridPane.add(new Label(filmName), 2, 0);
            gridPane.add(new Label(filmId), 3, 0);
            gridPane.add(new Label(zeit), 4, 0);
            entries.getItems().add(gridPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
