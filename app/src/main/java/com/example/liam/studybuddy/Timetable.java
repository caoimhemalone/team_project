package com.example.liam.studybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;

public class Timetable extends AppCompatActivity {

    Spinner spin_TT;
    ArrayAdapter<CharSequence> adapter_TT;
    Spinner spin_day_TT;
    ArrayAdapter<CharSequence> adapter_day_TT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        /**
         * @reference https://www.youtube.com/watch?v=28jA5-mO8K8&index=8&list=LL9QnUxf2Pctj2wyWa4GABCw YouTube: PRABEESH R K
         */

        spin_TT = (Spinner) findViewById(R.id.TT_spinner);
        spin_day_TT = (Spinner) findViewById(R.id.TT_day);
        adapter_TT = ArrayAdapter.createFromResource(this, R.array.TT_spinner_array, android.R.layout.simple_spinner_item);
        adapter_day_TT = ArrayAdapter.createFromResource(this, R.array.day_spinner_array, android.R.layout.simple_spinner_item);
        adapter_TT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_day_TT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_TT.setAdapter(adapter_TT);
        spin_day_TT.setAdapter(adapter_day_TT);
        spin_TT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            } // End of public void onItem........

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            } // End of public void onNothing......
        }); //End of spin_TT.setOnItem.......

        spin_day_TT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            } // End of public void onItem........

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            } // End of public void onNothing......
        }); //End of spin_TT.setOnItem.......

    }//End of protected void onCreate .....
} // End of public class .....

