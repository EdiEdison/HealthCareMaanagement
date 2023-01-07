package com.example.healthcaresystem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import  javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Statement;
import java.sql.Connection;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.ComboBox;




public class RegisterController implements Initializable{

    @FXML
    private ImageView sidebar2Imageview;
    @FXML
    private Button closebutton;
    @FXML
    private Label RegisterErrorMessage;
    @FXML
    private Label PasswordErrorMessage;
    @FXML
    private PasswordField setpassword;
    @FXML
    private PasswordField confirmPassword;
    @FXML
    private TextField setusername;
    @FXML
    private TextField age;
    @FXML
    private TextField telnumber;
    @FXML
    private ComboBox combo;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File sideFile = new File("Resources/kindpng_5943367.png");
        Image sideImage = new Image(sideFile.toURI().toString());
        sidebar2Imageview.setImage(sideImage);

        combo.getItems().addAll("MALE", "FEMALE");
    }


    public void RegisterButtonOnAction(ActionEvent event){
        if(setusername.getText().isBlank()==false && age.getText().isBlank()==false && telnumber.getText().isBlank()==false && ValidateMobile()) {
            registerUser();
            if (setpassword.getText().equals(confirmPassword.getText())) {
                registerUser();
                PasswordErrorMessage.setText("");
            } else {
                PasswordErrorMessage.setText("Passwords doesn't match");
            }
        }else{
            RegisterErrorMessage.setText("Please fill in the fields");
        }
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public boolean ValidateMobile(){
        Pattern p = Pattern.compile("(65|69)?[0-9]{7}");
        Matcher matcher = p.matcher(telnumber.getText());
        if(matcher.find() && matcher.group().equals(telnumber.getText())){
            return true;
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Mobile Number");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid MTN or ORANGE number ");
            alert.showAndWait();
        }
        return false;
    }

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();



        String username = setusername.getText();
        int a = Integer.parseInt(age.getText());
        int b = Integer.parseInt(telnumber.getText());
        String Sex = combo.getValue().toString();
        String Password = setpassword.getText();
        String InsertFields = "insert into healthdb.useraccounts( username, password, age, telnumber, sex) values('";
        String InsertValues = username +  "','" + Password + "','" + a + "','" + b + "','" + Sex + "')";
        String InsertToRegister = InsertFields + InsertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(InsertToRegister);
            RegisterErrorMessage.setText("User Registered successfully");
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
