package com.latihanpbo.topupgenius.LoginRegister;

import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
//    private static final String url = "jdbc:mysql://127.0.0.1:3306/topupgenius";
//    private static final String USER = "root";
//    private static final String PASSWORD = "";
    private static  final String dbName = "topupgenius";
    private static  final String dbUserName = "root";
    private static  final String dbPassword = "";


    public static Connection getConnection(){
        Connection con = null;
        try{
            String connectionString = "jdbc:mysql://127.0.0.1:3306/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
            con = DriverManager.getConnection(connectionString);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
