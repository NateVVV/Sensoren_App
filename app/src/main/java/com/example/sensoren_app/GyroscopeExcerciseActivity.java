package com.example.sensoren_app;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class GyroscopeExcerciseActivity extends Activity implements SensorEventListener{
    //declare vars
    private SensorManager sensorManager;
    private Sensor gyroSensor;
    private TextView X_Gyro_TextView;
    private TextView Y_Gyro_TextView;
    private TextView Z_Gyro_TextView;
    private int counter = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gyroscope_excercise);

        X_Gyro_TextView = findViewById(R.id.X_Gyro_TextView);
        Y_Gyro_TextView = findViewById(R.id.Y_Gyro_TextView);
        Z_Gyro_TextView = findViewById(R.id.Z_Gyro_TextView);


        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_GAME);

    }
    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Start the simulation
        sensorManager.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_GYROSCOPE)
            return;
        if(counter <10){
            counter++;
        }else {
            updateText(event);
            counter =0;
        }
    }

    private void updateText(SensorEvent event) {
        X_Gyro_TextView.setText(String.valueOf(event.values[0]));
        Y_Gyro_TextView.setText(String.valueOf(event.values[1]));
        Z_Gyro_TextView.setText(String.valueOf(event.values[2]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
