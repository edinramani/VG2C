package com.example.edin.vg2c;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
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
    private Button light_btn;
    private Button vent_btn;
    private Button heat_btn;
    private Button timeBtn;
    private Button tempBtn;
    private Button lightBtn;
    private Button humBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main2);

        timeBtn = (Button) findViewById(R.id.time_btn);
        tempBtn = (Button) findViewById(R.id.temp_btn);
        lightBtn = (Button) findViewById(R.id.light_btn);
        humBtn = (Button) findViewById(R.id.hum_btn);

        light_btn = (Button) findViewById(R.id.light_bytn);
        vent_btn = (Button) findViewById(R.id.vent_btn);
        heat_btn = (Button) findViewById(R.id.heat_btn);

        light_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("SensorStatus");
                objectParseQuery.getInBackground("D806BMvnzV", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (e == null) {
                            Boolean currentStatus = object.getBoolean("light");
                            if (currentStatus) {
                                object.put("light", false);
                            } else {
                                object.put("light", true);
                            }

                            object.saveInBackground();
                        }

                    }
                });
            }
        });

        vent_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("SensorStatus");
                objectParseQuery.getInBackground("D806BMvnzV", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (e == null) {
                            Boolean currentStatus2 = object.getBoolean("ventilator");
                            if (currentStatus2) {
                                object.put("ventilator", false);
                            } else {
                                object.put("ventilator", true);
                            }
                            object.saveInBackground();
                        }

                    }
                });
            }
        });
        heat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("SensorStatus");
                objectParseQuery.getInBackground("D806BMvnzV", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (e == null) {
                            Boolean currentStatus3 = object.getBoolean("heating");
                            if (currentStatus3) {
                                object.put("heating", false);
                            } else {
                                object.put("heating", true);
                            }
                            object.saveInBackground();
                        }

                    }
                });
            }
        });

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
//                            int sdfs = currentObject.getInt("light");
                            int tempNow = currentObject.getInt("temperature");
                            int lightNow = currentObject.getInt("light");
                            int humNow = currentObject.getInt("humidity");

                            Date date = new Date();
                            String test = dateFormat.format(date);

                            timeBtn.setText("Time: " + test);
                            tempBtn.setText("Temperature: " + tempNow);
                            lightBtn.setText("Light: " + lightNow);
                            humBtn.setText("Humidity: " + humNow);
                        } else {
                            Toast.makeText(Main2Activity.this, "Hata mesaji" + e, Toast.LENGTH_LONG).show();
                        }
                    }
                });
                handler.postDelayed(refresh, 3000);
            }
        };
        handler.post(refresh);
    }
}