package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    private Button signupBTN;
    private Button loginBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBTN = (Button)findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), HomeMenu.class);
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
