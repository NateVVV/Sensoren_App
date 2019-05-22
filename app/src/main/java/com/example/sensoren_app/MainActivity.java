package com.example.sensoren_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toAccelerometerExcercise(View view) {
        Intent i = new Intent(this, AccelerometerExcerciseActivity.class);
        startActivity(i);
    }

    public void toGyroscopeExcercise(View view) {
        Intent i = new Intent(this, GyroscopeExcerciseActivity.class);
        startActivity(i);
    }

    public void toMagnetometerExcercise(View view) {
        Intent i = new Intent(this, MagnetometerExcerciseActivity.class);
        startActivity(i);
    }

}