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

import java.util.HashMap;

public class ExamTimetable extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageButton backBTN;
    private Button roomBTN;
    private TextView userNameHeader, emailHeader, ETTdate, ETTsubject, ETTtime;
    String course, time, date, subject, year;
    private HashMap<String, String> details;
    Spinner spin_course_TT;
    ArrayAdapter<CharSequence> adapter_course_TT;
    Spinner spin_year_TT;
    ArrayAdapter<CharSequence> adapter_year_TT;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examtimetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        details = new HashMap<>();

        roomBTN = (Button) findViewById(R.id.room_btn);
        roomBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Timetable.class);
                startActivity(i);
                finish();
            }
        });

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

       ETTtime = (TextView) findViewById(R.id.ETTtime);
        ETTsubject = (TextView) findViewById(R.id.ETTsubject);
        ETTdate = (TextView) findViewById(R.id.ETTdate);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        userNameHeader.setText(globalVariable.getUserName());
        emailHeader.setText(globalVariable.getEmail());


        /**
         * @reference https://www.youtube.com/watch?v=28jA5-mO8K8&index=8&list=LL9QnUxf2Pctj2wyWa4GABCw YouTube: PRABEESH R K
         */

        spin_course_TT = (Spinner) findViewById(R.id.TT_spinner);
        spin_year_TT = (Spinner) findViewById(R.id.TT_year);
        adapter_course_TT = ArrayAdapter.createFromResource(this, R.array.exam_course_spinner, android.R.layout.simple_spinner_item);
        adapter_year_TT = ArrayAdapter.createFromResource(this, R.array.exam_year_spinner, android.R.layout.simple_spinner_item);
        adapter_course_TT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_year_TT.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_course_TT.setAdapter(adapter_course_TT);
        spin_year_TT.setAdapter(adapter_year_TT);
        spin_course_TT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            course = parent.getItemAtPosition(position).toString();
           new examtimetable().execute();
            } // End of public void onItem........

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            } // End of public void onNothing......
        }); //End of spin_course_TT.setOnItem.......

        spin_year_TT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
            year = parent.getItemAtPosition(position).toString();
           new examtimetable().execute();
            } // End of public void onItem........

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            } // End of public void onNothing......
        }); //End of spin_course_TT.setOnItem.......

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

        //noinspection SimplifiableIfStatement
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

    public void display(String time, String subject, String date){
        ETTtime.setText(time);
        ETTsubject.setText(subject);
        ETTdate.setText(date);
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

    private class examtimetable extends AsyncTask<Void, Void, Void>{
        private ProgressDialog pDialog;

        @Override
        protected void onPreExecute(){
            pDialog = new ProgressDialog(ExamTimetable.this);
            pDialog.setCancelable(false);
            showDialog();
        }

        @Override
        protected Void doInBackground(Void... params){
            DBHelper db = new DBHelper();
            details = db.examtimetable(course, year);
            return null;
        }

        @Override
        protected void onPostExecute(Void r){
            hideDialog();
            if(details != null){
                display(details.get("time"), details.get("subject"), details.get("date"));
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

