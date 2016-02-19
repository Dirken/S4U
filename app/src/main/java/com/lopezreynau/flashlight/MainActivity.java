package com.lopezreynau.flashlight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageButton flashLight = (ImageButton) findViewById(R.id.talkButton);
        flashLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTalking();
            }
        });

        final ImageButton screenLight = (ImageButton) findViewById(R.id.callButton);
        screenLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });
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

    }

    private void makeCall() {

    }
}
