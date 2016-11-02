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

public class SignUp extends AppCompatActivity {
    private EditText firstNameET, lastNameET, studentNumET, emailET, repeatEmailET, passwordET, repeatPasswordET;
    private Button signupBTN;

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
                if (firstNameET.getText().toString().isEmpty() ||
                        lastNameET.getText().toString().isEmpty() ||
                        studentNumET.getText().toString().isEmpty() ||
                        !emailET.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") ||
                        !repeatEmailET.getText().toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") ||
                        passwordET.getText().toString().isEmpty() ||
                        repeatPasswordET.getText().toString().isEmpty()) {
                    ShowMessage("Fill in all details!");
                } else {
                    new signUp().execute();
                    firstNameET.setText(null);
                    lastNameET.setText(null);
                    studentNumET.setText(null);
                    emailET.setText(null);
                    repeatEmailET.setText(null);
                    passwordET.setText(null);
                    repeatPasswordET.setText(null);
                }
            }
        });
    }

    private void ShowMessage(String msg) {
        Toast.makeText(SignUp.this, msg, Toast.LENGTH_LONG).show();
    }

    private class signUp extends AsyncTask<Void, Void, Void> {
        String firstName, lastName, studentNum, email, repeatEmail, password, repeatPassword;
        private ProgressDialog pDialog;
        private boolean result;

        @Override
        protected void onPreExecute() {
            firstName = firstNameET.getText().toString();
            lastName = lastNameET.getText().toString();
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
            //result = db.signUp(firstName, lastName, studentNum, email, repeatEmail, password, repeatPassword);
            return null;
        }

        @Override
        protected void onPostExecute(Void r) {
            hideDialog();
            if (result == false) {
                //result added
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

