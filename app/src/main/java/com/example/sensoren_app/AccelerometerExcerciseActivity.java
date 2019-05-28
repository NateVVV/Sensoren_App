package com.example.sensoren_app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AccelerometerExcerciseActivity extends Activity implements SensorEventListener{
    //declare vars
    private SensorManager sensorManager;
    private Sensor accelSensor;
    private TextView X_Accl_TextView;
    private TextView Y_Accl_TextView;
    private TextView Z_Accl_TextView;
    /*possible Speeds:
        SENSOR_DELAY_FASTEST
        SENSOR_DELAY_GAME
        SENSOR_DELAY_NORMAL
        SENSOR_DELAY_UI
     */
    private int speed = SensorManager.SENSOR_DELAY_NORMAL;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accelerometer_excercise);

        X_Accl_TextView = findViewById(R.id.X_Accl_TextView);
        Y_Accl_TextView = findViewById(R.id.Y_Accl_TextView);
        Z_Accl_TextView = findViewById(R.id.Z_Accl_TextView);


        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelSensor, speed);

    }
    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start the simulation
        sensorManager.registerListener(this, accelSensor, speed);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_ACCELEROMETER)
            return;
        updateText(event);
    }

    private void updateText(SensorEvent event) {
        X_Accl_TextView.setText(String.valueOf(event.values[0]));
        Y_Accl_TextView.setText(String.valueOf(event.values[1]));
        Z_Accl_TextView.setText(String.valueOf(event.values[2]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
