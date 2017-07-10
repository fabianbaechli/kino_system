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
import sample.JSON.SaveToJSOn;
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

public class ReservationController implements Initializable {

    @FXML
    public JFXTextField saalField;
    @FXML
    public JFXTextField DateField;
    @FXML
    public JFXTextField TimeField;
    @FXML
    public JFXTextField FilmField;
    @FXML
    public JFXTextField PriceField;

    @FXML
    public JFXButton bnt_close;

    @FXML
    public JFXComboBox<String> comboPerson;
    @FXML
    public JFXComboBox<String> comboSitzplatz;

    static UUID sitzplatz ;
    static UUID person ;

    int selectedPerson;
    int selectedPlatz;

    SaveToJSOn stj = new SaveToJSOn();


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        LoadUnits();

        bnt_close.setOnMouseClicked((event -> {
            Stage employeeStage = new Stage();
            stj.SaveAll();
            try {
                Pane page = (Pane) FXMLLoader.load(Main.class.getResource("../Views/Confirm.fxml"));
                Scene scene = new Scene(page);
                employeeStage.setScene(scene);
                employeeStage.setTitle("Abschluss");
                employeeStage.setResizable(false);
                employeeStage.show();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }));
        comboPerson.setOnMouseClicked((event -> {
            selectedPerson = comboPerson.getSelectionModel().selectedIndexProperty().get();
            person = PersonenSammelung.Personen.get(selectedPerson).getID();
        }));
        comboSitzplatz.setOnMouseClicked((event -> {
            selectedPlatz = comboSitzplatz.getSelectionModel().selectedIndexProperty().get();
            sitzplatz = Saal.sitzplätze.get(selectedPlatz).getID();
        }));

    }

    private void LoadUnits() {
        Vorstellung res = getVorstellung();

        if(res != null) {
            saalField.setText(res._saalID.toString());
            DateField.setText(res._date.toString());
            TimeField.setText(res._time.toString());
            FilmField.setText(res._filmID.toString());
            PriceField.setText(res.toString());

            comboPerson.getItems().clear();
            for (Person a : PersonenSammelung.Personen
                    ) {
                comboPerson.getItems().add(a.toString());
            }

            comboSitzplatz.getItems().clear();
            for (Sitzplatz b : Saal.sitzplätze
                    ) {
                comboPerson.getItems().add(b.platz);
            }
        }
    }

    public Vorstellung getVorstellung() {

        Vorstellung vor = null;

        for (Vorstellung a: Kinobuchungsystem.Vorstellungen
                ) {
            if (a.getID().equals( MainWindowController.ID)){
                vor = a;
            }
        }

        return vor;
    }
}
