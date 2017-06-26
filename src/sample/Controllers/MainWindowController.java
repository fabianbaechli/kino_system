package sample.Controllers;

import javafx.fxml.Initializable;
import sample.Models.Saal;

import java.net.URL;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
   // TODO: Import all Objects from fxml file

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        Saal saal = new Saal();
    }

    private void addRow(Saal saal, Date datum, Time time, Float price) {

    }
}
