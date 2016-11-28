package com.example.liam.studybuddy;

import android.app.Application;


/**
 * Created by Evan on 28/11/2016.
 */

public class GlobalClass extends Application {
    private String userName, email, studentNum;

    public String getUserName(){
        return userName;
    }

    public void setUserName(String aName){
        userName = aName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String aEmail){
        email = aEmail;
    }

    public String getStudentNum(){
        return studentNum;
    }

    public void setStudentNum(String aStudentNum){
        studentNum = aStudentNum;
    }


}
