package com.example.sensoren_app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MagnetometerExcerciseActivity extends Activity implements SensorEventListener{
    //declare vars
    private SensorManager sensorManager;
    private Sensor magnetoSensor;
    private TextView X_Magneto_TextView;
    private TextView Y_Magneto_TextView;
    private TextView Z_Magneto_TextView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.magnetometer_excercise);

        X_Magneto_TextView = findViewById(R.id.X_Magneto_TextView);
        Y_Magneto_TextView = findViewById(R.id.Y_Magneto_TextView);
        Z_Magneto_TextView = findViewById(R.id.Z_Magneto_TextView);


        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        magnetoSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this, magnetoSensor, SensorManager.SENSOR_DELAY_GAME);

    }
    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start the simulation
        sensorManager.registerListener(this, magnetoSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_MAGNETIC_FIELD)
            return;
        updateText(event);
    }

    private void updateText(SensorEvent event) {
        X_Magneto_TextView.setText(String.valueOf(event.values[0]));
        Y_Magneto_TextView.setText(String.valueOf(event.values[1]));
        Z_Magneto_TextView.setText(String.valueOf(event.values[2]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
