package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calender extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CalendarView calendarView;
    TextView displayEventsHeader;
    TextView displayEvents;
    private ImageButton backBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Profile.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_calendar) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Calender.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_study) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), StudySearch.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_messaging) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Messaging.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_timetable) {

        } else if (id == R.id.nav_home) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
