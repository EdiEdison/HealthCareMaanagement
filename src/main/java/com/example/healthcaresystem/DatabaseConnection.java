package com.example.healthcaresystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "healthdb";
        String databaseUser = "root";
        String databasePassword = "fornang123$";
        String Url = "jdbc:mysql://localhost/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(Url, databaseUser, databasePassword);
        }catch(Exception e){
            e.printStackTrace();
        }

        return  databaseLink;
    }
}
