package com.example.edin.vg2c;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.edin.vg2c.R.layout.activity_main3;

public class Main3Activity extends AppCompatActivity {

    private Button calisan;
    private Button dayBtn;
    private Button weekBtn;
    private Button monthBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(activity_main3);

        calisan = (Button) findViewById(R.id.calisan);
        dayBtn = (Button) findViewById(R.id.day_btn);
        weekBtn = (Button) findViewById(R.id.week_btn);
        monthBtn = (Button) findViewById(R.id.month_btn);

        calisan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sensorler = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(sensorler);
            }
        });

        dayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rapor = new Intent(Main3Activity.this, ChartActivity.class);
                startActivity(rapor);
            }
        });

        weekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rapor2 = new Intent(Main3Activity.this, Chart2Activity.class);
                startActivity(rapor2);
            }
        });

        monthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rapor3 = new Intent(Main3Activity.this, Chart3Activity.class);
                startActivity(rapor3);
            }
        });
    }
}