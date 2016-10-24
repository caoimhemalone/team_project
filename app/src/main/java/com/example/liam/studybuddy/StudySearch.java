//GOOD SPINNER EXAMPLE HTTPS://WWW.MKYONG.COM/ANDROID/ANDROID-SPINNER-DROP-DOWN-LIST-EXAMPLE/

package com.example.liam.studybuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View;


public class StudySearch extends AppCompatActivity {

    Spinner spin_comp;
            //spin_school, spin_bus;
    ArrayAdapter<CharSequence> adapter_comp;
    //ArrayAdapter<CharSequence> adapter_bus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);

        /**
         * @reference http://stackoverflow.com/questions/9262871/android-two-spinner-onitemselected
         */

      /*   // Select school spinner
        spin_school = (Spinner) findViewById(R.id.ss_spinner_school);
        ArrayAdapter<CharSequence> adapter_school = ArrayAdapter.createFromResource(this, R.array.school_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter_school.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_school.setAdapter(adapter_school);
        spin_school.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Select course, year, module
        spin_comp = (Spinner) findViewById(R.id.ss_spinner_comp);
        ArrayAdapter<CharSequence> adapter_comp = ArrayAdapter.createFromResource(this, R.array.comp_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter_comp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_comp.setAdapter(adapter_comp);
        spin_comp.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        spin_bus = (Spinner) findViewById(R.id.ss_spinner_bus);
        ArrayAdapter<CharSequence> adapter_bus = ArrayAdapter.createFromResource(this, R.array.bus_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter_comp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_bus.setAdapter(adapter_comp);
        spin_bus.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

    } */


      /*  public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){

        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.school_ss_spinner_array){

        }
        else if(spinner.getId() == R.id.comp_ss_spinner_array){

        }
        else {

        }

    } */


        /**
         * @reference https://www.youtube.com/watch?v=28jA5-mO8K8&index=8&list=LL9QnUxf2Pctj2wyWa4GABCw YouTube: PRABEESH R K
         */
/*
        spin_comp = (Spinner) findViewById(R.id.ss_spinner_comp);
        adapter_comp = ArrayAdapter.createFromResource(this, R.array.comp_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter_comp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_comp.setAdapter(adapter_comp);
        spin_comp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        }); */


        // spin_bus.setAdapter(adapter_bus);
        // adapter_bus = ArrayAdapter.createFromResource(this, R.array.bus_ss_spinner_array, android.R.layout.simple_spinner_item);
        // adapter_bus.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // spin_bus = (Spinner)findViewById(R.id.ss_spinner_bus);
       /* spin_bus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getBaseContext(), parent.getItemIdAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }

        });    */



        /*  BASIC SPINNER
        // this.arraySpinner = new String[]{
               // "School of Computing", "Course", "Year", "Module"

        //Spinner for school of computing
        final Spinner spin_comp = (Spinner) findViewById(R.id.ss_spinner_comp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.comp_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin_comp.setAdapter(adapter);

        // Spinner for school of business
       Spinner spin_bus  = (Spinner) findViewById(R.id.ss_spinner_bus);
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this, R.array.bus_ss_spinner_array, android.R.layout.simple_spinner_item);
        adapter_2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spin_bus.setAdapter(adapter_2);
        */
    }
}