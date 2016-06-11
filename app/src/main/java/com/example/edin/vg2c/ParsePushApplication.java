package com.example.edin.vg2c;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;


/**
 * Created by Edin on 11.6.2016.
 */
public class ParsePushApplication extends Application {
    public static final String YOUR_APPLICATION_ID = "M4YTqnRQEQ50T0KL6ZQ5MWCkjRVxW3SzTv2zKqmd";
    public static final String YOUR_CLIENT_KEY = "VWwzakza4Ti5Gx9c2Cug0aXqsnfBkxrIN7KYkTiY";

    @Override
    public void onCreate() {
        super.onCreate();
        //ParseObject.registerSubclass(.class);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        //PushService.
    }
}
