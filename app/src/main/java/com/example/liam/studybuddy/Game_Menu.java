package com.example.liam.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Evan on 15/12/2016.
 */

public class Game_Menu extends AppCompatActivity {

    Button bottle_spin,x_o;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        bottle_spin = (Button)findViewById(R.id.btn_bottleSpin);
        x_o = (Button)findViewById(R.id.btn_xsAndOs);

        bottle_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BottleActivity.class);
                startActivity(intent);
            }
        });

        x_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),XsAndOs.class);
                startActivity(intent);
            }
        });

    }
}
