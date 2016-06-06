package com.example.edin.vg2c;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Edin on 1.6.2016.
 */
public class Chart2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chart2);
        final GraphView graphView = (GraphView) findViewById(R.id.chart_view);

        ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("Sensor");

        objectParseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, objects.get(objects.size() - 2).getInt("humidity")),
                            new DataPoint(1, objects.get(objects.size() - 4).getInt("humidity")),
                            new DataPoint(2, objects.get(objects.size() - 6).getInt("humidity")),
                            new DataPoint(3, objects.get(objects.size() - 8).getInt("humidity")),
                            new DataPoint(4, objects.get(objects.size() - 10).getInt("humidity")),
                            new DataPoint(5, objects.get(objects.size() - 12).getInt("humidity")),
                            new DataPoint(6, objects.get(objects.size() - 14).getInt("humidity")),
                            new DataPoint(7, objects.get(objects.size() - 16).getInt("humidity")),
                            new DataPoint(8, objects.get(objects.size() - 18).getInt("humidity")),
                    });
                    graphView.addSeries(series);
                    series.setColor(Color.BLUE);
                    series.setThickness(8);
                } else {
                    Toast.makeText(Chart2Activity.this, "Hata mesaji" + e, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
