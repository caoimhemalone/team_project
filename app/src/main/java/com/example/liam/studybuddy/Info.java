package com.example.liam.studybuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.liam.studybuddy.R.id.emailHeader;
import static com.example.liam.studybuddy.R.id.moodleBTN;

/**
 * Created by Liam on 29/11/2016.
 */

public class Info extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton moodleBTN;
    private ImageButton nci360BTN;
    private ImageButton stuEmailBTN;

    private TextView userNameHeader, emailHeader, message;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        message = (TextView) findViewById(R.id.messageTV);
        userNameHeader = (TextView) header.findViewById(R.id.userName);
        emailHeader = (TextView) header.findViewById(R.id.emailHeader);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        message.setText("Hi " + globalVariable.getUserName()+",");
        userNameHeader.setText(globalVariable.getUserName());
        emailHeader.setText(globalVariable.getEmail());

        moodleBTN = (ImageButton)findViewById(R.id.moodleBTN);
        moodleBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri uri = Uri.parse("http://www.moodle.ncirl.ie"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        nci360BTN = (ImageButton)findViewById(R.id.nci360BTN);
        nci360BTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri uri = Uri.parse("https://nci360.ncirl.ie"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        stuEmailBTN = (ImageButton)findViewById(R.id.stuEmailBTN);
        stuEmailBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri uri = Uri.parse("https://outlook.office.com/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
