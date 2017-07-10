package sample.Controllers;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowReservationsController implements Initializable {
    @FXML
    JFXListView<GridPane> entries;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    private void addEntry(String personName, String personId, String filmName, String filmId, String anzahlPlaetze) {
        StackPane pane = null;
        try {
            pane = FXMLLoader.load(MainWindowController.class.getResource("../Views/ReservationEntry.fxml"));
            GridPane gridPane = (GridPane) pane.getChildren().get(0);

            gridPane.add(new Label(personName), 0, 0);
            gridPane.add(new Label(personId), 1, 0);
            gridPane.add(new Label(filmName), 2, 0);
            gridPane.add(new Label(filmId), 3, 0);
            gridPane.add(new Label(anzahlPlaetze), 4, 0);
            entries.getItems().add(gridPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
