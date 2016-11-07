package com.example.liam.studybuddy;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class Messaging extends AppCompatActivity {
    private static final String TAG = "ChatActivity";
    private ChatArrayAdapter adp;
    private ListView list;
    private EditText chatText;
    private ImageButton send;
    private boolean side = false;
    private String responseString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messaging);
        send = (ImageButton) findViewById(R.id.sendIcon);
        list = (ListView) findViewById(R.id.messagesContainer);
        adp = new ChatArrayAdapter(getApplicationContext(), R.layout.chat);
        list.setAdapter(adp);
        chatText = (EditText) findViewById(R.id.txtFldEnterMessage);
        chatText.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if((event.getAction()== KeyEvent.ACTION_DOWN)&&(keyCode== KeyEvent.KEYCODE_ENTER)){
                    return sendChatMessage();
                }
                    return false;
                }
        });
        send.setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){
                responseString= chatText.getText().toString();
                if(responseString.toString().equalsIgnoreCase("Hello")){
                    sendChatMessage();
                    chatText.setText("Hi How are you");
                    send.performClick();
                }
                else if(responseString.toString().equalsIgnoreCase("Im good thanks, How are you")){
                    sendChatMessage();
                    chatText.setText("Fine thank you");
                    send.performClick();
                }
                else if(responseString.toString().equalsIgnoreCase("I have a presentation ttyl")){
                    sendChatMessage();
                    chatText.setText("Ok good luck ttyl");
                    send.performClick();
                }
                else{
                    sendChatMessage();
                }
            }
        });
        list.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        list.setAdapter(adp);
        adp.registerDataSetObserver(new DataSetObserver(){
            public void OnChanged(){
                super.onChanged();
                list.setSelection(adp.getCount()-1);
            }
        });
    }
    private boolean sendChatMessage(){
        adp.add(new ChatMessage(side, chatText.getText().toString()));
        chatText.setText("");
        side = !side;
        return true;
    }
}
