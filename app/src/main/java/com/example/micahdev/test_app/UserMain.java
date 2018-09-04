package com.example.micahdev.test_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.concurrent.ThreadLocalRandom;

import java.util.Random;

public class UserMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        //Setup submit button listener
        findViewById(R.id.weatherButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Weather.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.randomButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Change to a random background color
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                view.setBackgroundColor(color);
            }
        });
    }
}
