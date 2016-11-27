package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TextView fullNameTV, studentNumTV, emailTV, myAccountTV;
    private Button forgotPasswordBTN;
    private ImageButton profileImageBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fullNameTV = (TextView)findViewById(R.id.fullNameTV);
        studentNumTV = (TextView)findViewById(R.id.studentNumTV);
        emailTV = (TextView)findViewById(R.id.emailTV);
        myAccountTV = (TextView)findViewById(R.id.myAccountTV);

        forgotPasswordBTN = (Button)findViewById(R.id.forgotPasswordBTN);
        profileImageBTN = (ImageButton)findViewById(R.id.profileImageBTN);


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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
