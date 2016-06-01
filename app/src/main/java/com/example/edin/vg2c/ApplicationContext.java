package com.example.edin.vg2c;

import android.app.Application;
import android.widget.Button;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;

/**
 * Created by Edin on 1.6.2016.
 */
public class ApplicationContext extends Application {

    Button test ;

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));

        ParseACL parseACL = new ParseACL();
        parseACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(parseACL, true);

        ParseInstallation.getCurrentInstallation().saveInBackground();


    }
}
