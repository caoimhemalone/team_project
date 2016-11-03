package com.example.liam.studybuddy;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @reference https://www.youtube.com/user/BowToKingBen
 * Created by Evan on 17/10/2016.
 */

public class DBHelper {
    private Connection conn;
    private String TAG = DBHelper.class.getSimpleName();

    public DBHelper(){
        conn = null;
        try {
            Class.forName(AppConfig.DRIVER);
            conn = DriverManager.getConnection(AppConfig.connectionString, AppConfig.db_user, AppConfig.db_pass);
            createTable();
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        } catch (ClassNotFoundException c) {
            Log.e(TAG, c.getMessage());
        }
    }

    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS " + AppConfig.TABLE_NAME + "(id int PRIMARY KEY auto_increment, " + "fName varchar(50)not null, " + "lName varchar(50)not null, " + "studentNum varchar(50) not null, " + "email varchar(50) not null, " + "repeatEmail varchar(50) not null, " + "password varchar(50) not null, " + "repeatPassword varchar(50) not null);";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        }
    }

    public boolean signup(String fName, String lName, String studentNum, String email, String repeatEmail, String password, String repeatPassword) {
        boolean result = false;

        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO " + AppConfig.TABLE_NAME + " (fName, lNAme, studentNum, email, repeatEmail, password, repeatPassword) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, fName);
            st.setString(2, lName);
            st.setString(3, studentNum);
            st.setString(4, email);
            st.setString(5, repeatEmail);
            st.setString(6, password);
            st.setString(7, repeatPassword);

            result = st.execute();
            st.close();
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        }
        return result;
    }
}


