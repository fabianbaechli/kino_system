package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.JSON.LoadFromJSON;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

    }


    public static void main(String[] args) {
        launch(args);
        new LoadFromJSON();
    }
}
