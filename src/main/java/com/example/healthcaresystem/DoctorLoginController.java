package com.example.healthcaresystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.fxml.Initializable;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;



public class DoctorLoginController implements Initializable {
    @FXML
    private Button CancelButton;
    @FXML
    private Label DocLoginErrorMessage;
    @FXML
    private TextField Docusername;
    @FXML
    private PasswordField Docpassword;
    @FXML
    private ImageView DoctorImageview;
    @FXML
    private ImageView DocloginImageview;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Resources/kindpng_1985195.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        DoctorImageview.setImage(brandingImage);

        File sidebarFile = new File("Resources/avatardefault_92824.png");
        Image sidebarImage = new Image(sidebarFile.toURI().toString());
        DocloginImageview.setImage(sidebarImage);
    }

    public void LoginButtonOnAction(ActionEvent event) {

        if (Docusername.getText().isBlank() == false && Docpassword.getText().isBlank() == false) {
            DoctorValidateLogin();
            //LoginErrorMessage.setText("You tried to Login");
        } else {
            DocLoginErrorMessage.setText("Please Enter User ID and Password");
        }
    }

    public void CancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void DoctorValidateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String ValidateLogin = "SELECT COUNT(1) FROM healthdb.doctor_account WHERE username = '" + Docusername.getText() + "' AND password = '" + Docpassword.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(ValidateLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    DocLoginErrorMessage.setText("Successful Login!!");
                } else {
                    DocLoginErrorMessage.setText("Invalid Password or Username");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
