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
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Calender extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Declaring variables

    private CalendarView calendarView;
    private TextView displayEventsHeader;
    private Button checkEvents;
    private String selectedDateInstance,toastText;
    private int month;
    private int day;
    private int year;


    private DatabaseReference root;
    private DatabaseReference dateRef ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Calendar");

        //Initializing variables and assigning them to there XML functions

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
        int c_day = currentDate.get(Calendar.DAY_OF_MONTH);
        int c_month = currentDate.get(Calendar.MONTH)+1;
        int c_year = currentDate.get(Calendar.YEAR);
        //geting current date in the set format
        String date = c_day+"-"+c_month+"-"+c_year ;
        //test date
        Log.d("current date is", date);
        calendarView = (CalendarView) findViewById(R.id.calendar);
        checkEvents = (Button) findViewById(R.id.btn_check_events);
        displayEventsHeader = (TextView) findViewById(R.id.txtEventsHeader);
        displayEventsHeader.setText(date);
        selectedDateInstance = date;
        toastText = "Select a date";
        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://team-project-studybuddy.firebaseio.com/Events");
        dateRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://team-project-studybuddy.firebaseio.com/Events").getRef();


        //when a date inside the calendar is clicked change the date and save the selscted date instance for use
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2){
                day = i2;
                month = i1+1;
                year = i;

                displayEventsHeader.setText(day+"-"+month+"-"+year);

                selectedDateInstance = displayEventsHeader.getText().toString();
            }

        });


        //When the check events button is clicked if the date field is not empty an instance of that date is sent to firebase
        //The date selected is sent to the new intent and the new intent is opened
        checkEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dateRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild(selectedDateInstance)){

                            Intent intent = new Intent(getApplicationContext(), Calendar_Events.class);
                            intent.putExtra("date_selected", selectedDateInstance);
                            startActivity(intent);

                        }else{
                            Map<String, Object> map_events = new HashMap<String, Object>();
                            map_events.put(selectedDateInstance, "");
                            root.updateChildren(map_events);

                            Intent intent = new Intent(getApplicationContext(), Calendar_Events.class);
                            intent.putExtra("date_selected", selectedDateInstance);
                            startActivity(intent);

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

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

        //New if statement for logout
        if (id == R.id.action_logout){
            Intent i = new Intent();
            i.setClass(getApplicationContext(), LogIn.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
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
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Timetable.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_home) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), NavActivity.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_info) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Info.class);
            startActivity(i);
            finish();

        }
        else if (id == R.id.nav_gamemenu) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Game_Menu.class);
            startActivity(i);
            finish();
        }


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
