package com.example.healthcaresystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class LoginController implements Initializable {
    @FXML
    private Button CancelButton;
    @FXML
    private Label LoginErrorMessage;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView loginImageview;
    @FXML
    private ImageView sidebarImageview;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Resources/avatardefault_92824.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        loginImageview.setImage(brandingImage);

        File sidebarFile = new File("Resources/kindpng_5943367.png");
        Image sidebarImage = new Image(sidebarFile.toURI().toString());
        sidebarImageview.setImage(sidebarImage);
    }

    public void LoginButtonOnAction(ActionEvent event) {

        if (username.getText().isBlank() == false && password.getText().isBlank() == false) {
            ValidateLogin();
            //LoginErrorMessage.setText("You tried to Login");
        } else {
            LoginErrorMessage.setText("Please Enter User ID and Password");
        }
    }

    public void CancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    public void ValidateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String ValidateLogin = "SELECT COUNT(1) FROM healthdb.useraccounts WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(ValidateLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    Home();
                    //LoginErrorMessage.setText("Successful Login!!");
                } else {
                    LoginErrorMessage.setText("Invalid Password or Username");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Home() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("User_Home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 666, 348);
            Stage UserStage = new Stage();
            UserStage.initStyle(StageStyle.UNDECORATED);
            UserStage.setScene(scene);
            UserStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Register.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 679, 351);
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(scene);
            registerStage.show();
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}