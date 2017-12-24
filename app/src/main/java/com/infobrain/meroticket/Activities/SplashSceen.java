package com.infobrain.meroticket.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.infobrain.meroticket.R;

public class SplashSceen extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_sceen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashSceen.this, MainActivity.class);
                SplashSceen.this.startActivity(mainIntent);
                SplashSceen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}



