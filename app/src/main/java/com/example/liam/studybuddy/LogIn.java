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

public class LogIn extends AppCompatActivity {

    private Button signupBTN;
    private Button loginBTN;
    String studentNum, password;
    private EditText studentNumET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        studentNumET = (EditText) findViewById(R.id.studentNumET);
        passwordET = (EditText) findViewById(R.id.passwordET);

        loginBTN = (Button)findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //new login().execute();
                Intent i = new Intent();
                i.setClass(getApplicationContext(), NavActivity.class);
                startActivity(i);
                finish();
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

    private class login extends AsyncTask<Void, Void, Void>{
        private ProgressDialog pDialog;
        private boolean result;

        @Override
        protected void onPreExecute(){
            studentNum = studentNumET.getText().toString();
            password = passwordET.getText().toString();
            result = false;

            pDialog = new ProgressDialog(LogIn.this);
            pDialog.setCancelable(false);
            pDialog.setMessage("Logging in...");
            showDialog();

        }

        @Override
        protected Void doInBackground(Void... params){

            DBHelper db = new DBHelper();
            //result = db.login(studentNum, password);
            return null;
        }

        @Override
        protected void onPostExecute(Void r){
            hideDialog();
            if (result == true){
                ShowMessage("Logging in...");
                Intent i = new Intent();
                i.setClass(getApplicationContext(), NavActivity.class);
                startActivity(i);
                finish();
            }
            else {
                ShowMessage("Username or Password incorrect");

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


  /*  //ONLY TEMPORARY WHILE CAOIMHE SORTS OUT GUI SO SHE CAN SEE THE SPINNER
    public void openSS (View view){
        Intent intent = new Intent(this, StudySearch.class);
        startActivity(intent);
        finish();
    }

    //ONLY TEMPORARY WHILE CAOIMHE SORTS OUT GUI SO SHE CAN SEE THE TIMETABLE
    public void openTT (View view){
        Intent intent = new Intent(this, Timetable.class);
        startActivity(intent);
        finish();
    }*/
}
