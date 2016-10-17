package com.example.liam.studybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText firstNameET, lastNameET, studentNumET, emailET, repeatEmailET, passwordET, repeatPasswordET;
    private Button signupBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstNameET = (EditText)findViewById(R.id.firstNameET);
        lastNameET = (EditText)findViewById(R.id.lastNameET);
        studentNumET = (EditText)findViewById(R.id.studentNumET);
        emailET = (EditText)findViewById(R.id.emailET);
        repeatEmailET = (EditText)findViewById(R.id.repeatEmailET);
        passwordET = (EditText)findViewById(R.id.passwordET);
        repeatPasswordET = (EditText)findViewById(R.id.repeatPasswordET);

        signupBTN = (Button)findViewById(R.id.signupBTN);
    }
}
