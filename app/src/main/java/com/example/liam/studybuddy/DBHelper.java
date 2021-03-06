package com.example.liam.studybuddy;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
            PreparedStatement st = conn.prepareStatement("INSERT INTO " + AppConfig.TABLE_NAME + " (fName, lName, studentNum, email, repeatEmail, password, repeatPassword) VALUES(?,?,?,?,?,?,?)");
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

    public ResultSet checkUserSignup(String studentNum){
        ResultSet temp = null;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM " + AppConfig.TABLE_NAME + " WHERE studentNum = ?");
            st.setString(1, studentNum);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                temp = rs;
            }
            else{
                temp = null;
            }
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        }
        return temp;
    }

    public ResultSet checkUserLogin(String studentNum, String password){
        ResultSet temp = null;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM " + AppConfig.TABLE_NAME + " WHERE studentNum = ? AND password = ?");
            st.setString(1, studentNum);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                temp = rs;
            }
            else{
                temp = null;
            }
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        }
        return temp;
    }

    public HashMap<String,String> login (String studentNum, String password){
        HashMap<String, String> details = new HashMap<String, String>();
        try{
            PreparedStatement st = conn.prepareStatement("SELECT * FROM " + AppConfig.TABLE_NAME + " WHERE studentNum =? AND password=?" );
            st.setString(1, studentNum);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                details.put("fName", rs.getString("fName"));
                details.put("lName", rs.getString("lName"));
                details.put("studentNum", rs.getString("studentNum"));
                details.put("email", rs.getString("email"));
            }
        } catch (SQLException s) {
            Log.e(TAG, s.getMessage());
        } return details;
    }

    // Fpr room timetable
    public List<RoomTimetableInfo> timetable (String day, String room) {
        List<RoomTimetableInfo> details = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM room_timetable WHERE day =? AND room =?");
            st.setString(1, day);
            st.setString(2, room);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                RoomTimetableInfo rt  = new RoomTimetableInfo( rs.getInt("id"),
                        rs.getString("day"),
                        rs.getString("course"),
                        rs.getString("room"),
                        rs.getString("time"));
                details.add(rt);
            }
        }catch(SQLException s){
                Log.e(TAG, s.getMessage() + "");
            }
        return details;
        }

    // For exam timetable
    public List<ExamTimetableInfo> examtimetable (String course, String year) {
        List<ExamTimetableInfo> details = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM exam_timetable WHERE course =? AND year =?");
            st.setString(1, course);
            st.setString(2, year);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ExamTimetableInfo et  = new ExamTimetableInfo( rs.getInt("id"),
                        rs.getString("time"),
                        rs.getInt("year"),
                        rs.getString("subject"),
                        rs.getString("date"),
                        rs.getString("course"));
                details.add(et);
            }
        }catch(SQLException s){
            Log.e(TAG, s.getMessage() + "");
        }
        return details;
    }
}


