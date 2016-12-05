package com.example.liam.studybuddy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Evan on 03/12/2016.
 */

public class Calendar_Events extends AppCompatActivity {

    private Button back_to_calendar,addEventBtn;
    //private ListView events_listView;
    private TextView event_display,display_date;
    private  EditText addEventInput;

    private ArrayAdapter<String> eventsArrayAdapter;
    private ArrayList<String> list_of_events = new ArrayList<>();

    private DatabaseReference root;


    private String dateInstance,temp_key_events;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_events);

        back_to_calendar = (Button)findViewById(R.id.btn_back_calendar);
        addEventBtn = (Button)findViewById(R.id.btn_add_event_input);
        addEventInput = (EditText) findViewById(R.id.text_add_event_input);
        //events_listView = (ListView)findViewById(R.id.events_listView);
        event_display = (TextView) findViewById(R.id.event_textView);
        display_date = (TextView) findViewById(R.id.txtView_display_date_selected);

        dateInstance = getIntent().getExtras().get("date_selected").toString();
        Log.v("Date selected is", dateInstance);//checking to see correct date is passed
        display_date.setText(dateInstance);

        root = FirebaseDatabase.getInstance().getReferenceFromUrl("https://team-project-studybuddy.firebaseio.com/Events").child(dateInstance);

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (addEventInput.getText().toString()==""){

                }else{

                    Map<String,Object> map2_events = new HashMap<String, Object>();
                    temp_key_events = root.push().getKey();
                    root.updateChildren(map2_events);

                    DatabaseReference event_root = root.child(temp_key_events);

                    Map<String,Object> map3_events = new HashMap<String, Object>();
                    map3_events.put("event",addEventInput.getText().toString());

                    event_root.updateChildren(map3_events);
                }
                addEventInput.setText("");
            }
        });

        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                append_events(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                append_events(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private String event_text;

    private void append_events(DataSnapshot dataSnapshot) {

        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext()){

            event_text = (String) ((DataSnapshot)i.next()).getValue();

            event_display.append(event_text+" \n");

        }
    }
}
