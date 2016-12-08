package com.example.liam.studybuddy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Timetable extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton backBTN;
    private Button examBTN;
    private TextView userNameHeader, emailHeader, TT_time1, TT_time2, TT_time3, TT_time4, TT_time5, TT_time6, TT_time7, TT_time8, TT_course1, TT_course2, TT_course3, TT_course4, TT_course5, TT_course6, TT_course7, TT_course8;
    String day, course, time, room;
    private List<RoomTimetableInfo> details;
    Spinner spin_TT;
    ArrayAdapter<CharSequence> adapter_TT;
    Spinner spin_day_TT;
    ArrayAdapter<CharSequence> adapter_day_TT;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        details = new ArrayList<>();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);


        userNameHeader = (TextView)header.findViewById(R.id.userName);
        emailHeader = (TextView)header.findViewById(R.id.emailHeader);

        TT_time1 = (TextView) findViewById(R.id.TT_time1);
        TT_time2 = (TextView) findViewById(R.id.TT_time2);
        TT_time3 = (TextView) findViewById(R.id.TT_time3);
        TT_time4 = (TextView) findViewById(R.id.TT_time4);
        TT_time5 = (TextView) findViewById(R.id.TT_time5);
        TT_time6 = (TextView) findViewById(R.id.TT_time6);
        TT_time7 = (TextView) findViewById(R.id.TT_time7);
        TT_time8 = (TextView) findViewById(R.id.TT_time8);

        TT_course1 = (TextView) findViewById(R.id.TT_course1);
        TT_course2 = (TextView) findViewById(R.id.TT_course2);
        TT_course3 = (TextView) findViewById(R.id.TT_course3);
        TT_course4 = (TextView) findViewById(R.id.TT_course4);
        TT_course5 = (TextView) findViewById(R.id.TT_course5);
        TT_course6 = (TextView) findViewById(R.id.TT_course6);
        TT_course7 = (TextView) findViewById(R.id.TT_course7);
        TT_course8 = (TextView) findViewById(R.id.TT_course8);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        userNameHeader.setText(globalVariable.getUserName());
        emailHeader.setText(globalVariable.getEmail());



        examBTN = (Button) findViewById(R.id.examBTN);
        examBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent i;
                    i = new Intent(getApplicationContext(), ExamTimetable.class);
                    startActivity(i);
                    finish();
            }
        });


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
                room = parent.getItemAtPosition(position).toString();
                new timetable().execute();
            } // End of public void onItem........

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            } // End of public void onNothing......
        }); //End of spin_TT.setOnItem.......

        spin_day_TT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
                day = parent.getItemAtPosition(position).toString();
                new timetable().execute();
            } // End of public void onItem........

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            } // End of public void onNothing......
        }); //End of spin_TT.setOnItem.......

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }//End of protected void onCreate .....


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

    public void display(String time1, String course1, String time2, String course2, String time3, String course3, String time4, String course4, String time5, String course5, String time6, String course6, String time7, String course7, String time8, String course8){
        TT_time1.setText(time1);
        TT_course1.setText(course1);
        TT_time2.setText(time2);
        TT_course2.setText(course2);
        TT_time3.setText(time3);
        TT_course3.setText(course3);
        TT_time4.setText(time4);
        TT_course4.setText(course4);
        TT_time5.setText(time5);
        TT_course5.setText(course5);
        TT_time6.setText(time6);
        TT_course6.setText(course6);
        TT_time7.setText(time7);
        TT_course7.setText(course7);
        TT_time8.setText(time8);
        TT_course8.setText(course8);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Timetable Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class timetable extends AsyncTask<Void, Void, Void> {
        private ProgressDialog pDialog;


        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(Timetable.this);
            pDialog.setCancelable(false);
            showDialog();
        }

        @Override
        protected Void doInBackground(Void... params) {
            DBHelper db = new DBHelper();
            details = db.timetable(day, room);
            return null;
        }

        @Override
        protected void onPostExecute(Void r) {
            hideDialog();
            if (details != null) {
                    display(
                            details.get(0).getTime(),
                            details.get(0).getCourse(),
                            details.get(1).getTime(),
                            details.get(1).getCourse(),
                            details.get(2).getTime(),
                            details.get(2).getCourse(),
                            details.get(3).getTime(),
                            details.get(3).getCourse(),
                            details.get(4).getTime(),
                            details.get(4).getCourse(),
                            details.get(5).getTime(),
                            details.get(5).getCourse(),
                            details.get(6).getTime(),
                            details.get(6).getCourse(),
                            details.get(7).getTime(),
                            details.get(7).getCourse());
            }
        }

        private void showDialog() {
            if (!pDialog.isShowing()) {
                pDialog.show();
            }
        }

        private void hideDialog() {
            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }
        }
    }
} // End of public class .....

