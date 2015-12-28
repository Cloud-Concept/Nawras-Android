package com.cloudconcept;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import utilities.ActivitiesLauncher;
import utilities.LayoutResource;

/**
 * Created by Abanoub Wagdy on 12/15/2015.
 */
public class SplashActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(LayoutResource.getSplashResource());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivitiesLauncher.openHomeActivity(getApplicationContext());
                finish();
//                Intent mainIntent = new Intent(SplashActivity.this,
//                        HomeActivity.class);
//                SplashActivity.this.startActivity(mainIntent);
//                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
