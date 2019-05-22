package com.example.sensoren_app;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private int permissionRequestCode = 512;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,
                new String [] {
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.INTERNET,
                },
                permissionRequestCode);
    }

    public void toAccelerometerExcercise(View view) {
        System.out.println("Accel Button clicked");
        Intent i = new Intent(this, AccelerometerExcerciseActivity.class);
        System.out.println("start Accel Excercise");
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