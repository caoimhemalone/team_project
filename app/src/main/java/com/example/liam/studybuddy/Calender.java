package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calender extends AppCompatActivity {

    CalendarView calendarView;
    TextView displayEventsHeader;
    TextView displayEvents;
    private ImageButton backBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        //get instance of Calendar
        Calendar currentDate = Calendar.getInstance();
        // Declaring format of date
        SimpleDateFormat DMY = new SimpleDateFormat("dd-mm-yyyy");
        //geting current date in the set format
        String date = DMY.format(currentDate.getTime());
        //test date
        Log.d("current date is", date);
        calendarView = (CalendarView) findViewById(R.id.calendar);
        displayEvents = (TextView) findViewById(R.id.txtDisplayEvents);
        displayEventsHeader = (TextView) findViewById(R.id.txtEventsHeader);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2){
                int month = i1+1;
                displayEventsHeader.setText("Selected date: " + i2+"/"+month+"/"+i);
                //displayEvents.setText("You Have Events Scheduled Today");
                if(displayEventsHeader.getText().toString().equals("Selected date: 8/11/2016")){
                    displayEvents.setText("Extra Programming Classes");

                }
                else if(displayEventsHeader.getText().toString().equals("Selected date: 9/11/2016")){
                    displayEvents.setText("Report Due Today");
                }
                else{
                    displayEvents.setText("No Events Scheduled Today");
                }
            }

        });

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
