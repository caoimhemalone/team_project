package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class HomeMenu extends AppCompatActivity {

    private ImageButton imageBTN;
    private ImageButton imageBTN2;
    private ImageButton imageBTN3;
    private ImageButton imageBTN6;
    private ImageButton imageBTN7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        imageBTN = (ImageButton)findViewById(R.id.imageButton);
        imageBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Profile.class);
                startActivity(i);
                finish();
            }
        });
        imageBTN2 = (ImageButton)findViewById(R.id.imageButton2);
        imageBTN2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Calender.class);
                startActivity(i);
                finish();
            }
        });
        imageBTN3 = (ImageButton)findViewById(R.id.imageButton3);
        imageBTN3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), StudySearch.class);
                startActivity(i);
                finish();
            }
        });
        imageBTN6 = (ImageButton)findViewById(R.id.imageButton6);
        imageBTN6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Messaging.class);
                startActivity(i);
                finish();
            }
        });
        imageBTN7 = (ImageButton)findViewById(R.id.imageButton7);
        imageBTN7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Timetable.class);
                startActivity(i);
                finish();
            }
        });
    }


}
