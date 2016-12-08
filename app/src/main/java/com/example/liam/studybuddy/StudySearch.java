//GOOD SPINNER EXAMPLE HTTPS://WWW.MKYONG.COM/ANDROID/ANDROID-SPINNER-DROP-DOWN-LIST-EXAMPLE/

package com.example.liam.studybuddy;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.liam.studybuddy.R.string.AF;
import static com.example.liam.studybuddy.R.string.BUS;
import static com.example.liam.studybuddy.R.string.HRM;
import static com.example.liam.studybuddy.R.string.MP;
import static com.example.liam.studybuddy.R.string.school_comp;


public class StudySearch extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    ExpandableListAdapter listAdapter;
//    ExpandableListView expListView;
//    List<String> listDataHeader;
//    HashMap<String, List<String>> listDataChild;
    String bus1, bus2, bus3, bus4, comp1, comp2, comp3, comp4;

    private TextView userNameHeader, emailHeader;
    private Button schcompBTN, schbusBTN;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);

        bus1 = getString(MP);
        bus2 = getString(HRM);
        bus3 = getString(BUS);
        bus4 = getString(AF);
        comp1 = getString(R.string.BIS);
        comp2 = getString(R.string.COMP);
        comp3 = getString(R.string.MTB);
        comp4 = getString(R.string.TM);


//        TextView TV = (TextView) findViewById(R.id.lblListItem);
//        TV.setMovementMethod(LinkMovementMethod.getInstance());

        userNameHeader = (TextView) header.findViewById(R.id.userName);
        emailHeader = (TextView) header.findViewById(R.id.emailHeader);

        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        userNameHeader.setText(globalVariable.getUserName());
        emailHeader.setText(globalVariable.getEmail());


//        // get the list view
//        expListView = (ExpandableListView) findViewById(R.id.lvExp);
//
//        //preparing list data
//        prepareListData();
//
//        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
//
//        //setting list adapter
//        expListView.setAdapter(listAdapter);
//
//        // ListView Group click listener
//        expListView.setOnGroupClickListener(new OnGroupClickListener() {
//
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                // Toast.makeText(getApplicationContext(),
//                // "Group Clicked" + listDataHeader.get(groupPosition),
//                //Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //Listview Group collapsed listener
//        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
//            }
//        });

        //Listview on child click listener

      //  expListView.setOnChildClickListener(new OnChildClickListener() {
                                                //  TextView TV = (TextView) findViewById(R.id.lblListItem);


//                                                @Override
//                                                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                                                   // Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " : " + listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
//                                                    // TV.setMovementMethod(LinkMovementMethod.getInstance());
//
////                if (childPosition == R.string.MP) {
////                    Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
////                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////                    startActivity(intent);
////
////                } else if (childPosition == R.string.HRM) {
////                    Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
////                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////                    startActivity(intent);
////
////                } else if (childPosition == R.string.BUS) {
////                    Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
////                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////                    startActivity(intent);
////
////                } else if (childPosition == R.string.AF) {
////                    Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
////                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
////                    startActivity(intent);
////
////                }
////                                                    return false;
//                                                }

                                          //  });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


        schcompBTN = (Button)findViewById(R.id.schcompBTN);
        schcompBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), SchoolBusLinks.class);
                startActivity(i);
            }
        });

        schbusBTN = (Button)findViewById(R.id.schbusBTN);
        schbusBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent j = new Intent();
                j.setClass(getApplicationContext(), SchoolBusLinks.class);
                startActivity(j);
            }
        });
    }

    //PREPARING THE LIST DATA

//    private void prepareListData() {
//        listDataHeader = new ArrayList<String>();
//        listDataChild = new HashMap<String, List<String>>();
//
//        // Adding child data
//        listDataHeader.add("School of Business");
//        listDataHeader.add("School of Computing");
//
//        // Adding child data
//        List<String> school_bus = new ArrayList<String>();
//        school_bus.add(bus1);
//        school_bus.add(bus2);
//        school_bus.add(bus3);
//        school_bus.add(bus4);
//
//
//        List<String> school_comp = new ArrayList<String>();
//        school_comp.add(comp1);
//        school_comp.add(comp2);
//        school_comp.add(comp3);
//        school_comp.add(comp4);
//
//
//        listDataChild.put(listDataHeader.get(0), school_bus); //Header, Child data
//        listDataChild.put(listDataHeader.get(1), school_comp);
//
//    }
//
//    public boolean linkSelected(){
//        if (.equals(R.string.MP)) {
//            Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//
//        } else if (listDataChild.equals(R.string.HRM)) {
//            Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//
//        } else if (listDataChild.equals(R.string.BUS)) {
//            Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//
//        } else if (listDataChild.equals(R.string.AF)) {
//            Uri uri = Uri.parse("http://courses.ncirl.ie/index.cfm/page/course/courseId/1701"); // missing 'http://' will cause crashed
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//
//        }
//        return false;
//    }


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
        if (id == R.id.action_logout) {
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

        } else if (id == R.id.nav_info) {
            Intent i = new Intent();
            i.setClass(getApplicationContext(), Info.class);
            startActivity(i);
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("StudySearch Page") // TODO: Define a title for the content shown.
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
}