module com.example.healthcaresystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;
    requires  javafx.graphics;


    opens com.example.healthcaresystem to javafx.fxml;
    exports com.example.healthcaresystem;
}