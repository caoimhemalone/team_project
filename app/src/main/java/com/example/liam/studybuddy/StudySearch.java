//GOOD SPINNER EXAMPLE HTTPS://WWW.MKYONG.COM/ANDROID/ANDROID-SPINNER-DROP-DOWN-LIST-EXAMPLE/

package com.example.liam.studybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class StudySearch extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);

       // this.arraySpinner = new String[]{
               // "School of Computing", "Course", "Year", "Module"


        //Spinner for school of computing
        Spinner spin_comp = (Spinner) findViewById(R.id.ss_spinner_comp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.comp_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_comp.setAdapter(adapter);

        // Spinner for school of business
        Spinner spin_bus  = (Spinner) findViewById(R.id.ss_spinner_bus);

        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this, R.array.bus_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter_2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spin_bus.setAdapter(adapter_2);
    }

}