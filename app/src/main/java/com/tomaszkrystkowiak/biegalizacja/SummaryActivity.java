package com.tomaszkrystkowiak.biegalizacja;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends Activity {

    private TextView distanceResultView;
    private TextView averageSpeedView;
    private TextView caloriesView;
    private Button showRouteButton;
    private Button saveRouteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        distanceResultView = findViewById(R.id.distance_result_view);
        averageSpeedView = findViewById(R.id.average_speed_view);
        caloriesView = findViewById(R.id.calories_view);
        showRouteButton = findViewById(R.id.show_route_button);
        saveRouteButton = findViewById(R.id.save_route_button);
        fillTextFields();
    }

    private void fillTextFields(){

        distanceResultView.setText("Distance: "+ Math.round(getIntent().getFloatExtra("distance",0f))+"m");
    }
}
