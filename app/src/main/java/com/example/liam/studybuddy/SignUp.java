package com.example.liam.studybuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;
import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    private EditText firstNameET, lastNameET, studentNumET, emailET, repeatEmailET, passwordET, repeatPasswordET;
    private Button signupBTN;
    String fName, lName, studentNum, email, repeatEmail, password, repeatPassword;
    private ResultSet result = null;
    private HashMap<String, String> details;
    GlobalClass globalVariable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        firstNameET = (EditText) findViewById(R.id.firstNameET);
        lastNameET = (EditText) findViewById(R.id.lastNameET);
        studentNumET = (EditText) findViewById(R.id.studentNumET);
        emailET = (EditText) findViewById(R.id.emailET);
        repeatEmailET = (EditText) findViewById(R.id.repeatEmailET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        repeatPasswordET = (EditText) findViewById(R.id.repeatPasswordET);

        signupBTN = (Button) findViewById(R.id.signupBTN);

        signupBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fName = firstNameET.getText().toString();
                lName = lastNameET.getText().toString();
                studentNum = studentNumET.getText().toString();
                email = emailET.getText().toString();
                repeatEmail = repeatEmailET.getText().toString();
                password = passwordET.getText().toString();
                repeatPassword = repeatPasswordET.getText().toString();
                if(fName.isEmpty() ||
                        lName.isEmpty() ||
                        studentNum.isEmpty() ||
                        !email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") ||
                        !repeatEmail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") ||
                        !password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}") ||
                        !repeatPassword.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}") ||
                        !repeatEmail.equals(email) ||
                        !repeatPassword.equals(password)){
                            if(fName.isEmpty()){
                                ShowMessage("First Name field is empty!");
                            }
                            else if(lName.isEmpty()){
                                ShowMessage("Last Name field is empty!");
                            }
                            else if(studentNum.isEmpty()){
                                ShowMessage("Student Number field is empty!");
                            }
                            else if(email.isEmpty()){
                                ShowMessage("Email field is empty!");
                            }
                            else if(!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                                ShowMessage("Email field is invalid!");
                            }
                            else if(repeatEmail.isEmpty()){
                                ShowMessage("Repeat Email field is empty!");
                            }
                            else if(!repeatEmail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                                ShowMessage("Repeat Email field is invalid!");
                            }
                            else if(password.isEmpty()){
                                ShowMessage("Password field is empty!");
                            }
                            else if(!password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}")){
                                ShowMessage("Password must be 6-20 characters and contain atleast one uppercase and lowercase letter and one digit from 0-9");
                            }
                            else if(repeatPassword.isEmpty()){
                                ShowMessage("Repeat Password field is empty!");
                            }
                            else if(!repeatPassword.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}")){
                                ShowMessage("Repeat Password must be 6-20 characters and contain atleast one uppercase and lowercase letter and one digit from 0-9");
                            }
                            else if(!repeatEmail.equals(email)){
                                ShowMessage("Emails do not match!");
                            }
                            else if(!repeatPassword.equals(password)){
                                ShowMessage("Passwords do not match!");
                            }
                }
                else{
                    new checkUserSignup().execute();
                }
            }
        });
    }

    private void ShowMessage(String msg) {
        Toast.makeText(SignUp.this, msg, Toast.LENGTH_LONG).show();
    }

    private class checkUserSignup extends AsyncTask<Void, Void, Void>{
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute(){
            studentNum = studentNumET.getText().toString();

            pDialog = new ProgressDialog(SignUp.this);
            pDialog.setCancelable(false);
            pDialog.setMessage("Checking User...");
            showDialog();
        }

        @Override
        protected Void doInBackground(Void... params) {

            DBHelper db = new DBHelper();
            result = db.checkUserSignup(studentNum);
            return null;
        }

        @Override
        protected void onPostExecute(Void r) {
            hideDialog();
            if (result != null) {
                //user exists
                ShowMessage("User already exists, proceeding to login");
                Intent i = new Intent();
                i.setClass(getApplicationContext(), LogIn.class);
                startActivity(i);
                finish();
            } else {
                //user doesn't exist, goes to signup method
                ShowMessage("User does not yet exist");
                new signUp().execute();
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


    private class signUp extends AsyncTask<Void, Void, Void> {
        private ProgressDialog pDialog;
        private boolean result;

        @Override
        protected void onPreExecute() {
            fName = firstNameET.getText().toString();
            lName = lastNameET.getText().toString();
            studentNum = studentNumET.getText().toString();
            email = emailET.getText().toString();
            repeatEmail = repeatEmailET.getText().toString();
            password = passwordET.getText().toString();
            repeatPassword = repeatPasswordET.getText().toString();
            result = false;

            pDialog = new ProgressDialog(SignUp.this);
            pDialog.setCancelable(false);
            pDialog.setMessage("Signing Up...");
            showDialog();
        }

        @Override
        protected Void doInBackground(Void... params) {

            DBHelper db = new DBHelper();
            result = db.signup(fName, lName, studentNum, email, repeatEmail, password, repeatPassword);
            return null;
        }

        @Override
        protected void onPostExecute(Void r) {
            hideDialog();
            if (result == false) {
                //signup is true
                ShowMessage("Sign Up complete!");
                Intent i = new Intent();
                i.setClass(getApplicationContext(), LogIn.class);
                startActivity(i);
                finish();
            } else {
                //details weren't added
                ShowMessage("Details not added!");
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
}

