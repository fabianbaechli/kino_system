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
import sample.Models.Saal;
import sample.Sammlungen.FilmeSammlung;
import sample.ViewModels.Kinobuchungsystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController implements Initializable {
    @FXML
    private
    JFXListView<GridPane> vorstellungen_anzeige;

    @FXML
    private
    JFXButton createUser;

    private int selectedItem;
    public static UUID ID;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        createUser.setOnMouseClicked((event -> {
            try {
                StackPane stackPane = FXMLLoader.load(MainWindowController.class.getResource("../Views/CreateUserView.fxml"));
                Stage stage = new Stage();
                stage.setTitle("New User");
                stage.setScene(new Scene(stackPane));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));

        vorstellungen_anzeige.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    selectedItem = vorstellungen_anzeige.getSelectionModel().selectedIndexProperty().get();

                    ID = Kinobuchungsystem.Vorstellungen.get(selectedItem).getID();

                    Stage employeeStage = new Stage();
                    try {
                        Pane page = (Pane) FXMLLoader.load(Main.class.getResource("View/CreateReservation.fxml"));
                        Scene scene = new Scene(page);
                        employeeStage.setScene(scene);
                        employeeStage.setTitle("ReservationErfassen");
                        employeeStage.setResizable(false);
                        employeeStage.show();
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });


        LoadFromJSON loader = new LoadFromJSON();
        loader.LoadAll();
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
            gridPane.setOnMouseClicked((mouseEvent) -> {
                if (mouseEvent.getClickCount() == 2) {
                    try {
                        StackPane stackPane = FXMLLoader.load(MainWindowController.class.getResource("../Views/CreateReservation.fxml"));
                        AnchorPane anchorPane = (AnchorPane) stackPane.getChildren().get(0);
                        JFXComboBox comboBox = (JFXComboBox) anchorPane.getChildren().get(0);
                        JFXTextField numberOfParticipants = (JFXTextField) anchorPane.getChildren().get(1);

                        comboBox.getItems().add("Fabian Bächli");
                        comboBox.getItems().add("Daniel Peters");
                        comboBox.getItems().add("Leonard Schütz");
                        comboBox.getItems().add("Fabrice Bosshard");
                        comboBox.getItems().add("Igor Cetkovic");

                        numberOfParticipants.setOnKeyPressed((event -> {
                            String input = event.getText();
                            System.out.println(input);
                            try {
                                Integer number = Integer.parseInt(input);
                            } catch (Exception e) {
                                numberOfParticipants.setText("");
                            }

                        }));
                        Stage stage = new Stage();
                        stage.setTitle("New Node");
                        stage.setScene(new Scene(stackPane));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            gridPane.add(saalLabel, 0, 0);
            gridPane.add(filmLabel, 1, 0);
            gridPane.add(datumLabel, 2, 0);
            gridPane.add(timeLabel, 3, 0);
            gridPane.add(priceLabel, 4, 0);

            //Vorstellungen.getItems().add(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
