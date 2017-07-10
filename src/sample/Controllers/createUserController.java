package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import sample.JSON.LoadFromJSON;
import sample.JSON.SaveToJSOn;
import sample.Models.Person;
import sample.Models.Saal;
import sample.Sammlungen.PersonenSammelung;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fabrice on 03.07.2017.
 */
public class createUserController implements Initializable {

    @FXML
    JFXTextField inputName;
    @FXML
    JFXTextField inputVorname;
    @FXML
    JFXTextField inputTel;
    @FXML
    JFXTextField inputEmail;

    @FXML
    JFXButton bntCancel;
    @FXML
    JFXButton bntAccept;

    String name;
    String vorname;
    String tel;
    String email;

    SaveToJSOn svt = new SaveToJSOn();


    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

        bntCancel.setOnAction((event) -> {
            Stage stage = (Stage) bntCancel.getScene().getWindow();
            stage.close();
        });

        bntAccept.setOnAction((event) -> {
            name = inputName.getText();
            vorname = inputVorname.getText();
            tel = inputTel.getText();
            email = inputEmail.getText();

            if (checkValidation()){
                PersonenSammelung.Personen.add(new Person(name,vorname,email,tel));
                svt.SavePersonen(SaveToJSOn.PersonCon);
                Stage stage = (Stage) bntAccept.getScene().getWindow();
                stage.close();
            }
        });

    }

    private boolean checkValidation() {
        inputEmail.setStyle("-fx-background-color: #FFFFFF;");
        inputTel.setStyle("-fx-background-color: #FFFFFF;");
        inputVorname.setStyle("-fx-background-color: #FFFFFF;");
        inputName.setStyle("-fx-background-color: #FFFFFF;");

        Boolean flag = false;
        if (inputEmail.getText().isEmpty() || inputTel.getText().isEmpty()
                || inputVorname.getText().isEmpty() || inputName.getText().isEmpty()){
            if (inputEmail.getText().isEmpty()){
                inputEmail.setStyle("-fx-background-color: #FF0000;");
            }
            if (inputTel.getText().isEmpty()){
                inputTel.setStyle("-fx-background-color: #FF0000;");
            }
            if (inputName.getText().isEmpty()){
                inputName.setStyle("-fx-background-color: #FF0000;");
            }
            if (inputVorname.getText().isEmpty()){
                inputVorname.setStyle("-fx-background-color: #FF0000;");
            }
            flag=true;
        }
        if (!isValidEmailAddress(inputEmail.getText())){
            inputEmail.setStyle("-fx-background-color: #FF0000;");
            flag=true;
        }if (!isValidTelephone(inputTel.getText())){
            inputTel.setStyle("-fx-background-color: #FF0000;");
            flag=true;
        }
        if (flag){
            return false;
        }else{
            return true;
        }

    }

    private boolean isValidTelephone(String text) {
        Pattern pattern = Pattern.compile("\\d{3} \\d{3} \\d{2} \\d{2}");
        Matcher matcher = pattern.matcher(text);

        Pattern pattern2 = Pattern.compile("\\d{3}\\d{3}\\d{2}\\d{2}");
        Matcher matcher2 = pattern2.matcher(text);

        Boolean flag = false;

        if (matcher.matches()){
            flag=true;
        }
        else if (matcher2.matches()){
            flag=true;
        }
        if (flag){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isValidEmailAddress(String text) {
        String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = text;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }
}
