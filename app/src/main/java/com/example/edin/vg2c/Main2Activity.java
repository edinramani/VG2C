package com.example.edin.vg2c;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.edin.vg2c.R.layout.activity_main2;

public class Main2Activity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable refresh;


    private Button timeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main2);

        timeBtn = (Button) findViewById(R.id.time_btn);
        final DateFormat dateFormat = new SimpleDateFormat("HH:mm");

        final ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("Sensor");

        refresh = new Runnable() {
            @Override
            public void run() {
                objectParseQuery.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e == null) {
                            int length = objects.size();
                            ParseObject currentObject = objects.get(length - 1);
                            int sdfs = currentObject.getInt("light");

                            Date date = new Date();
                            String test = dateFormat.format(date);
                            timeBtn.setText("Time: " + test);
                        } else {
                            Toast.makeText(Main2Activity.this, "Hata mesaji" + e, Toast.LENGTH_LONG).show();
                        }
                    }
                });
                handler.postDelayed(refresh, 5000);
            }
        };
        handler.post(refresh);
    }
}