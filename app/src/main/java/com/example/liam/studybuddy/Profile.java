package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private TextView fullNameTV, studentNumTV, emailTV, myAccountTV;
    private Button forgotPasswordBTN;
    private ImageButton profileImageBTN;
    private ImageButton backBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullNameTV = (TextView)findViewById(R.id.fullNameTV);
        studentNumTV = (TextView)findViewById(R.id.studentNumTV);
        emailTV = (TextView)findViewById(R.id.emailTV);
        myAccountTV = (TextView)findViewById(R.id.myAccountTV);

        forgotPasswordBTN = (Button)findViewById(R.id.forgotPasswordBTN);
        profileImageBTN = (ImageButton)findViewById(R.id.profileImageBTN);

        backBTN = (ImageButton)findViewById(R.id.backBTN);
        backBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), NavActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
