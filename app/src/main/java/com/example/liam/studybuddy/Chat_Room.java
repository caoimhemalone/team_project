package com.example.liam.studybuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Evan on 20/11/2016.
 */
public class Chat_Room extends AppCompatActivity{

    //Declaring vriables

    private ImageButton btn_send_msg;
    private EditText input_msg;
    private TextView chat_convo;
    private Button btn_Back_To_Forums;
    private String user_name,room_name,temp_key,toastText;
    private DatabaseReference root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_room);

        //Initialize and connect them to corresponding values in XML when activity is created

        btn_send_msg = (ImageButton) findViewById(R.id.btn_send);
        input_msg = (EditText) findViewById(R.id.msg_input);
        chat_convo = (TextView) findViewById(R.id.msg_textView);
        btn_Back_To_Forums = (Button) findViewById(R.id.btn_Back_To_Forums);

        user_name = getIntent().getExtras().get("user_name").toString();
        room_name = getIntent().getExtras().get("room_name").toString();
        setTitle(" Room- " + room_name);
        toastText = "Can't send a blank message";

        root = FirebaseDatabase.getInstance().getReference().child("Chat").child(room_name);

        //Just a back button to navigate back to messaging activity
        btn_Back_To_Forums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Messaging.class);
                startActivity(intent);

            }
        });

        //When the send message button is clicked if the edit text is not empty take the value from the edit text and place it in a hash map to be sent to Firebase
        btn_send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input_msg.getText().toString()==""){

                    Toast.makeText(getApplicationContext(),toastText,Toast.LENGTH_LONG).show();

                }else {
                    //when btn is clicked a key is generated and added as a child of the root in FireBase using a HashMap to move the data
                    Map<String,Object> map = new HashMap<String, Object>();
                    temp_key = root.push().getKey();
                    root.updateChildren(map);

                    //reference to the new child root created above is declared
                    DatabaseReference message_root = root.child(temp_key);

                    //a second HashMap is created to add user name and there message to the FireBase
                    Map<String,Object> map2 = new HashMap<String, Object>();
                    map2.put("name",user_name);
                    map2.put("msg",input_msg.getText().toString());

                    message_root.updateChildren(map2);
                }
                input_msg.setText("");

            }
        });

        //when data is changed in the new child in FireBase update in the folowing ways
        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                //Adds the data taking from the Firebase to the View
                append_chat_convo(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                append_chat_convo(dataSnapshot);

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

    //Create 2 variables to hold the data coming from the FireBase
    private String chat_msg,chat_user_name;

    // Take the data of the FireBase and stores it in the variables and adds it to the TextView in the ScrollView
    private void append_chat_convo(DataSnapshot dataSnapshot) {

        Iterator i = dataSnapshot.getChildren().iterator();

        while (i.hasNext()){

            chat_msg = (String) ((DataSnapshot)i.next()).getValue();
            chat_user_name = (String) ((DataSnapshot)i.next()).getValue();

            chat_convo.append(chat_user_name+" : "+chat_msg+" \n");
            //could insert if statement if username == logged in username setTextcolor = blue etc..

        }
    }
}
