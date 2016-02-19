package com.lopezreynau.flashlight;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Typeface font = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");

        Button webButton = (Button) findViewById(R.id.web_button);
        Button gitButton = (Button) findViewById(R.id.github_button);
        Button gmailButton = (Button) findViewById(R.id.gmail_button);

        webButton.setTypeface(font);
        gitButton.setTypeface(font);
        gmailButton.setTypeface(font);

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("http://www.lopezreynau.com");
            }
        });

        gitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("https://github.com/Reynau/");
            }
        });

        gmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "xavi.lopez.reynau@gmail.com", null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }

    private void openURL(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
