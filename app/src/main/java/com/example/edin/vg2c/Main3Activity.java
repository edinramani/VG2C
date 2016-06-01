package com.example.edin.vg2c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import static com.example.edin.vg2c.R.layout.activity_main3;

public class Main3Activity extends AppCompatActivity {

    private Button calisan;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(activity_main3);

        ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("Sensor");

        objectParseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    ParseObject currentObject = objects.get(0);
                    int sdfs = currentObject.getInt("light");
//                    String shdfds = String.valueOf(sdfs);
                    Toast.makeText(Main3Activity.this,"Veri: "+sdfs,Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Main3Activity.this,"Hata mesaji"+e,Toast.LENGTH_LONG).show();
                }
            }
        });


        calisan = (Button) findViewById(R.id.calisan);

        calisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sensorler = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(sensorler);
            }
        });
    }
}