package sample.Controllers;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import sample.Models.Saal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    JFXListView Vorstellungen;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        Saal saal = new Saal("1", "123", "127839182", "5 Meter", true);
        addRow(saal, "Iron Man", "12.12.2017", "08:15", 14.95F);
    }

    private void addRow(Saal saal, String film, String datum, String time, Float price) {
        Label saalLabel = new Label(saal.getName());
        Label filmLabel = new Label(film);
        Label datumLabel = new Label(datum);
        Label timeLabel = new Label(time);
        Label priceLabel = new Label(price.toString());

        StackPane pane = null;
        try {
            pane = FXMLLoader.load(MainWindowController.class.getResource("../Views/vorstellungEntry.fxml"));
            GridPane gridPane = (GridPane) pane.getChildren().get(0);

            gridPane.add(saalLabel, 0, 0);
            gridPane.add(filmLabel, 1, 0);
            gridPane.add(datumLabel, 2, 0);
            gridPane.add(timeLabel, 3, 0);
            gridPane.add(priceLabel, 4, 0);

            Vorstellungen.getItems().add(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
