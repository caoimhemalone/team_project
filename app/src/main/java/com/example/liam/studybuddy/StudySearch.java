//GOOD SPINNER EXAMPLE HTTPS://WWW.MKYONG.COM/ANDROID/ANDROID-SPINNER-DROP-DOWN-LIST-EXAMPLE/

package com.example.liam.studybuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
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



public class StudySearch extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private ImageButton backBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);

        backBTN = (ImageButton)findViewById(R.id.backBTN);
        backBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent();
                i.setClass(getApplicationContext(), HomeMenu.class);
                startActivity(i);
                finish();
            }
        });

        // get the list view
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        //preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        //setting list adapter
        expListView.setAdapter(listAdapter);

        // ListView Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener(){

            @Override
                public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id){
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked" + listDataHeader.get(groupPosition),
                //Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });

        //Listview Group collapsed listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition)+" Collapsed", Toast.LENGTH_SHORT).show();
            }
        });

        //Listview on child click listener

        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,int groupPosition, int childPosition, long id){
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition)+" : "+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    //PREPARING THE LIST DATA

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("School of Business");
        listDataHeader.add("School of Computing");

        // Adding child data
        List<String> school_bus = new ArrayList<String>();
        school_bus.add("Course");
        school_bus.add("Year");
        school_bus.add("Module");

        //Need to add if statement to hide current ExpList and show another when course or year or module is selected 

        List<String> school_comp = new ArrayList<String>();
        school_comp.add("Course");
        school_comp.add("Year");
        school_comp.add("Module");

      // List<String> bus_course = new ArrayList<String>();
        //bus_course.add("course 1");
        //bus_course.add("course 2");
        //bus_course.add("course 3");

        listDataChild.put(listDataHeader.get(0), school_bus); //Header, Child data
        listDataChild.put(listDataHeader.get(1), school_comp);

    }

}