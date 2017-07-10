package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sample.JSON.LoadFromJSON;
import sample.Main;
import sample.Models.Film;
import sample.Models.Person;
import sample.Models.Saal;
import sample.Models.Sitzplatz;
import sample.Sammlungen.FilmeSammlung;
import sample.Sammlungen.PersonenSammelung;
import sample.ViewModels.Kinobuchungsystem;
import sample.ViewModels.Reservation;
import sample.ViewModels.Vorstellung;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Confirm implements Initializable {

    @FXML
    public Label saal;
    @FXML
    public Label Film;
    @FXML
    public Label Datum;
    @FXML
    public Label Zeit;
    @FXML
    public Label Preis;
    @FXML
    public Label Name;
    @FXML
    public Label Vorname;
    @FXML
    public Label Email;
    @FXML
    public Label Tel;
    @FXML
    public Label Platz;

    @FXML
    public JFXButton bnt_close;


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        LoadUnits();

        bnt_close.setOnMouseClicked((event -> {
            Stage stage = (Stage) bnt_close.getScene().getWindow();
            stage.close();
        }));

    }

    private void LoadUnits() {
        Vorstellung res = getVorstellung();
        Person pers = getPerson();
        Sitzplatz platz = getPlatz();

        saal.setText(res._saalID.toString());
        Datum.setText(res._date.toString());
        Zeit.setText(res._time.toString());
        Film.setText(res._filmID.toString());
        Preis.setText(res.toString());

        Name.setText(pers.name);
        Vorname.setText(pers.vorname);
        Email.setText(pers.email);
        Tel.setText(pers.telefonnummer);

        Platz.setText(platz.platz);

    }

    public Vorstellung getVorstellung() {

        Vorstellung vor = null ;

        for (Vorstellung a: Kinobuchungsystem.Vorstellungen
                ) {
            if (a.getID() == MainWindowController.ID){
                vor = a;
            }
        }

        return vor;
    }

    public Person getPerson() {
        Person person=null;

        for (Person b: PersonenSammelung.Personen
             ) {
            if (b.getID() == ReservationController.person){
                person = b;
            }
        }

        return person;
    }

    public Sitzplatz getPlatz() {
        Sitzplatz platz=null;

        for (Sitzplatz c: Saal.sitzplätze
             ) {
            if (c.getID() == ReservationController.sitzplatz){
                platz = c;
            }
        }

        return platz;
    }
}
