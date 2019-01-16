package com.tomaszkrystkowiak.biegalizacja;

import android.os.Handler;
import android.widget.TextView;

public class Stoper {

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

    public void startTiming(){
        startTime = System.currentTimeMillis();
        timerHandler.postDelayed(timerRunnable, 0);
        timerHandler.removeCallbacks(timerRunnable);
    }

    public void stopTiminig(){
        timerHandler.removeCallbacks(timerRunnable);
    }
}
