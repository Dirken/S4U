package com.swaghat.s4u;

import android.content.Intent;
import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    private ImageButton talkButton;
    private ImageButton callButton;

    Queue stringBuffer;
    boolean isTalking;

    String text;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        talkButton = (ImageButton) findViewById(R.id.talkButton);
        talkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTalking();
            }
        });

        callButton = (ImageButton) findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });

        et=(EditText)findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.action_help:
                Intent help = new Intent(this, Help.class);
                startActivity(help);
                break;
            case R.id.action_about:
                Intent about = new Intent(this, About.class);
                startActivity(about);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startTalking() {
        ConvertTextToSpeech();
    }

    private void makeCall() {

    }
    private void ConvertTextToSpeech() {
        // TODO Auto-generated method stub
        text = et.getText().toString();
        Log.w("E", text);

    }

    private class readTextThread extends AsyncTask<Void,Void,Void> {
        Queue buffer;

        TextToSpeech tts;

        protected void onPreExecute() {
            buffer = stringBuffer;
            tts=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    // TODO Auto-generated method stub
                    if(status == TextToSpeech.SUCCESS){
                        int result=tts.setLanguage(Locale.US);
                        if(result==TextToSpeech.LANG_MISSING_DATA ||
                                result==TextToSpeech.LANG_NOT_SUPPORTED){
                            Log.e("error", "This Language is not supported");
                        }
                        else  ConvertTextToSpeech();
                    }
                    else
                        Log.e("error", "Initilization Failed!");
                }
            });
            isTalking = true;
        }

        protected Void doInBackground(Void... urls) {
            while(!buffer.isEmpty()) {
                String word = (String) buffer.remove();
                talk(word);
            }
            return null;
        }

        protected void onPostExecute() {
            isTalking = false;
        }

        private void talk(String text) {
            if(! (text==null||"".equals(text)))
                tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}


