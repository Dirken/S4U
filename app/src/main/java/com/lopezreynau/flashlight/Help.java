package com.lopezreynau.flashlight;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        int color = Color.parseColor("#6baed6"); //The color u want
        ImageView firstIcon = (ImageView)findViewById(R.id.firstIcon);
        firstIcon.setColorFilter(color);
        ImageView secondIcon = (ImageView)findViewById(R.id.secondIcon);
        secondIcon.setColorFilter(color);
    }
}
