package com.example.liam.studybuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.HashMap;

public class LogIn extends AppCompatActivity {

    private Button signupBTN;
    private Button loginBTN;
    String userName, email, studentNum, password;
    private EditText studentNumET, passwordET;
    private ResultSet result = null;
    private HashMap<String, String> details;
    GlobalClass globalVariable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        details = new HashMap<>();

        globalVariable = (GlobalClass) getApplicationContext();


        studentNumET = (EditText) findViewById(R.id.studentNumET);
        passwordET = (EditText) findViewById(R.id.passwordET);

        loginBTN = (Button)findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //new login().execute();
                new checkUserLogin().execute();
            }
        });

        signupBTN = (Button)findViewById(R.id.signupBTN);
        signupBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), SignUp.class);
                startActivity(i);
                finish();
            }
        });


    }
    private void ShowMessage(String msg){
        Toast.makeText(LogIn.this, msg, Toast.LENGTH_LONG).show();
    }

    private class checkUserLogin extends AsyncTask<Void, Void, Void>{
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute(){
            studentNum = studentNumET.getText().toString();
            password = passwordET.getText().toString();

            pDialog = new ProgressDialog(LogIn.this);
            pDialog.setCancelable(false);
            pDialog.setMessage("Checking User...");
            showDialog();
        }

        @Override
        protected Void doInBackground(Void... params) {

            DBHelper db = new DBHelper();
            result = db.checkUserLogin(studentNum,password);
            return null;
        }

        @Override
        protected void onPostExecute(Void r) {
            hideDialog();
            if (result != null) {
                //user exists
                new login().execute();
            } else {
                //user doesn't exist, goes to signup method
                ShowMessage("Username or password incorrect!");
            }
        }

        private void showDialog() {
            if (!pDialog.isShowing()) {
                pDialog.show();
            }
        }

        private void hideDialog() {
            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }
        }
    }
    private class login extends AsyncTask<Void, Void, Void>{
        private ProgressDialog pDialog;


        @Override
        protected void onPreExecute(){
            studentNum = studentNumET.getText().toString();
            password = passwordET.getText().toString();

            pDialog = new ProgressDialog(LogIn.this);
            pDialog.setCancelable(false);
            pDialog.setMessage("Logging in...");
            showDialog();

        }

        @Override
        protected Void doInBackground(Void... params){

            DBHelper db = new DBHelper();
            details = db.login(studentNum, password);
            return null;
        }

        @Override
        protected void onPostExecute(Void r){
            hideDialog();
            if (details != null){
                globalVariable.setUserName(details.get("fName")+ " " +details.get("lName"));
                globalVariable.setStudentNum(details.get("studentNum"));
                globalVariable.setEmail(details.get("email"));
                Intent i = new Intent();
                i.setClass(getApplicationContext(), NavActivity.class);
                startActivity(i);
                finish();
            }
        }

        private void showDialog() {
            if(!pDialog.isShowing()){
                pDialog.show();
            }
        }

        private void hideDialog(){
            if(pDialog.isShowing()){
                pDialog.dismiss();
            }
        }

    }
}
