package com.example.edin.vg2c;

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
public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chart);
        final GraphView graphView = (GraphView) findViewById(R.id.chart_view);

        ParseQuery<ParseObject> objectParseQuery = ParseQuery.getQuery("Sensor");

        objectParseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                            new DataPoint(0, objects.get(objects.size() - 1).getInt("light")),
                            new DataPoint(1, objects.get(objects.size() - 2).getInt("light")),
                            new DataPoint(2, objects.get(objects.size() - 3).getInt("light")),
                            new DataPoint(3, objects.get(objects.size() - 4).getInt("light")),
                            new DataPoint(4, objects.get(objects.size() - 5).getInt("light")),
                            new DataPoint(5, objects.get(objects.size() - 6).getInt("light")),

                            new DataPoint(0, objects.get(objects.size() - 1).getInt("light")),
                            new DataPoint(1, objects.get(objects.size() - 5).getInt("light")),
                            new DataPoint(2, objects.get(objects.size() - 10).getInt("light")),
                            new DataPoint(3, objects.get(objects.size() - 15).getInt("light")),
                            new DataPoint(4, objects.get(objects.size() - 20).getInt("light")),
                            new DataPoint(5, objects.get(objects.size() - 25).getInt("light")),
                    });
                    graphView.addSeries(series);

                } else {
                    Toast.makeText(ChartActivity.this, "Hata mesaji" + e, Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
