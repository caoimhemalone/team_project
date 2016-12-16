package com.example.liam.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Evan on 15/12/2016.
 */

public class BottleActivity extends AppCompatActivity {

    ImageView bottle;
    Button spinBtn,backB;
    int angle;
    Random rand;
    boolean respin = false;
    String toast_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle);

        bottle = (ImageView)findViewById(R.id.imageView_bottle);
        spinBtn = (Button) findViewById(R.id.spin_btn);
        backB =(Button) findViewById(R.id.btn_backToGameMenu);

        rand = new Random();
        toast_text ="e.g: Answer 2 questions on topic studied";


        spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (respin){

                    angle = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(angle, 360,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    spinBtn.setText("Spin");

                    respin = false;

                }else {

                    angle = rand.nextInt(3600)+360;
                    RotateAnimation rotate = new RotateAnimation(0, angle,RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    rotate.setFillAfter(true);
                    rotate.setDuration(3600);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);
                    spinBtn.setText("Reset");
                    Toast.makeText(getApplicationContext(),toast_text,Toast.LENGTH_LONG).show();

                    respin = true;
                }


            }
        });

        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Game_Menu.class);
                startActivity(intent);
            }
        });
    }
}
