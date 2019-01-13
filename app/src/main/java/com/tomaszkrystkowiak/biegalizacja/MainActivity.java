package com.tomaszkrystkowiak.biegalizacja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button timerButton;
    private Button mapButton;
    private TextView timerView;
    long startTime = 0;

    private Handler timerHandler = new Handler();
    private Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerButton = findViewById(R.id.timer_button);
        timerButton.setOnClickListener(new TimerButtonClick());
        timerButton.setText(R.string.button_start);
        mapButton = findViewById(R.id.map_button);
        mapButton.setOnClickListener(new MapButtonClick());
        timerView = findViewById(R.id.timer_view);

    }

    private void startMapActivity(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    private class TimerButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if(timerButton.getText().equals("start")) {
                startTime = System.currentTimeMillis();
                timerHandler.postDelayed(timerRunnable, 0);
                timerButton.setText(R.string.button_stop);
            }
            else{
                timerHandler.removeCallbacks(timerRunnable);
                timerButton.setText(R.string.button_start);
            }
        }
    }

    private class MapButtonClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            startMapActivity();
        }
    }
}
