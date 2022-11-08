package com.muiedhossain.noteapp20.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.window.SplashScreen;

import com.muiedhossain.noteapp20.MainActivity;
import com.muiedhossain.noteapp20.R;

public class SpalshScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SpalshScreenActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 2000);

    }
}