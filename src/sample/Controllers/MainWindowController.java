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
import sample.Models.Saal;
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

    @FXML
    JFXButton showReservations;

    private int selectedItem;
    public static UUID ID;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        Saal saalA = new Saal("123", "Sall A", "15m", true, UUID.randomUUID().toString());
        addRow(saalA, "Iron Man", "12-12-2017", "12:30", 18.00F);
        addRow(saalA, "Avengers", "12-12-2017", "12:30", 18.00F);

        Saal saalB = new Saal("123", "Sall B", "15m", true, UUID.randomUUID().toString());
        addRow(saalB, "Lion King", "12-12-2017", "13:00", 16.00F);
        addRow(saalB, "Ninja Turtles", "12-12-2017", "14:00", 1.00F);
        addRow(saalB, "Transformers", "12-12-2017", "15:00", 15.00F);
        addRow(saalB, "The Crash", "12-12-2017", "17:00", 20.00F);
        addRow(saalB, "Iron Man", "12-12-2017", "18:30", 18.00F);
        addRow(saalB, "Avengers", "12-12-2017", "18:30", 18.00F);
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

        showReservations.setOnMouseClicked((event -> {
            try {
                StackPane stackPane = FXMLLoader.load(MainWindowController.class.getResource("../Views/showReservations.fxml"));
                Stage stage = new Stage();
                stage.setTitle("All reservations");
                stage.setScene(new Scene(stackPane));
                stage.show();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
                        Pane page = (Pane) FXMLLoader.load(Main.class.getResource("../Views/CreateReservation.fxml"));
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
                        Pane stackPane = FXMLLoader.load(MainWindowController.class.getResource("../Views/CreateReservation.fxml"));
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

            vorstellungen_anzeige.getItems().add(gridPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
