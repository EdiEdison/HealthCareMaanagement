package com.example.healthcaresystem;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class UserHomeController implements Initializable {
    @FXML
    private Button edit_profile;
    @FXML
    private Button home;
    @FXML
    private Button appointment;
    @FXML
    private Button prescription;
    @FXML
    private Button receipts;
    @FXML
    private TextField username2;
    @FXML
    private TextField userage;
    @FXML
    private TextField status;
    @FXML
    private ImageView userimage;
    @FXML
    private ImageView ageimage;
    @FXML
    private ImageView statusimage;
    @FXML
    private ImageView homeimage;
    @FXML
    private ImageView presimage;
    @FXML
    private ImageView appointimage;
    @FXML
    private ImageView recimage;
    @FXML
    private ImageView logo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("Resources/Hlogo.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        logo.setImage(brandingImage);

        File ageFile = new File("Resources/icons8-age-96.png");
        Image ageImage = new Image(ageFile.toURI().toString());
        ageimage.setImage(ageImage);

        File presFile = new File("Resources/icons8-note-96.png");
        Image presImage = new Image(presFile.toURI().toString());
        presimage.setImage(presImage);

        File statusFile = new File("Resources/icons8-ok-48.png");
        Image statusImage = new Image(statusFile.toURI().toString());
        statusimage.setImage(statusImage);

        File appointFile = new File("Resources/icons8-medical-doctor-96.png");
        Image appointImage = new Image(appointFile.toURI().toString());
        appointimage.setImage(appointImage);

        File userFile = new File("Resources/icons8-female-user-50.png");
        Image userImage = new Image(userFile.toURI().toString());
        userimage.setImage(userImage);

        File recFile = new File("Resources/icons8-receipt-approved-96.png");
        Image recImage = new Image(recFile.toURI().toString());
        recimage.setImage(recImage);

        File homeFile = new File("Resources/icons8-hospital-sign-96.png");
        Image homeImage = new Image(homeFile.toURI().toString());
        homeimage.setImage(homeImage);


    }


}
