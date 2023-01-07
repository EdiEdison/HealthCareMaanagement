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



public class AdminController implements Initializable {
    @FXML
    private Button CancelButton;
    @FXML
    private Label AdLoginErrorMessage;
    @FXML
    private TextField Adusername;
    @FXML
    private PasswordField Adpassword;
    @FXML
    private ImageView AdminImageview;
    @FXML
    private ImageView AdloginImageview;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Resources/kindpng_1985195.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        AdminImageview.setImage(brandingImage);

        File sidebarFile = new File("Resources/avatardefault_92824.png");
        Image sidebarImage = new Image(sidebarFile.toURI().toString());
        AdloginImageview.setImage(sidebarImage);
    }

    public void LoginButtonOnAction(ActionEvent event) {

        if (Adusername.getText().isBlank() == false && Adpassword.getText().isBlank() == false) {
            DoctorValidateLogin();
            //LoginErrorMessage.setText("You tried to Login");
        } else {
            AdLoginErrorMessage.setText("Please Enter User ID and Password");
        }
    }

    public void CancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void DoctorValidateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String ValidateLogin = "SELECT COUNT(1) FROM healthdb.admin_account WHERE username = '" + Adusername.getText() + "' AND password = '" + Adpassword.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(ValidateLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    AdLoginErrorMessage.setText("Successful Login!!");
                } else {
                    AdLoginErrorMessage.setText("Invalid Password or Username");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
