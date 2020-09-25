package com.example.sensorlistenerexample;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor rotationSensor;
    private static final int SENSOR_DELAY = 500*1000;
    private static final int FROM_RADS_TO_DEGS=-57;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        try{
            sensorManager = (SensorManager) getSystemService(Activity.SENSOR_SERVICE);
            rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
            sensorManager.registerListener(
                    this,
                    rotationSensor,
                    SENSOR_DELAY);
        } catch (Exception e){
            Toast.makeText(this, "Hardware compatibility issue!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor==rotationSensor){
            if (event.values.length>4){
                float[] truncatedRotationVector= new float[4];
                System.arraycopy(event.values,0,truncatedRotationVector,0,4);
                update(truncatedRotationVector);
            } else  {
                update(event.values);
            }
        }
    }

    private void update(float[] truncatedRotationVector) {
        float[] rotationMatrix=new float[9];
        sensorManager.getRotationMatrixFromVector(rotationMatrix, truncatedRotationVector);
        int worldAxisX=sensorManager.AXIS_X;
        int worldAxisZ=sensorManager.AXIS_Z;
        float[] adjustedRotationMatrix=new float[9];
        sensorManager.remapCoordinateSystem(rotationMatrix,worldAxisX,worldAxisZ,adjustedRotationMatrix);
        float[] orientation=new float[3];
        sensorManager.getOrientation(adjustedRotationMatrix,orientation);
        float pitch = orientation[1] * FROM_RADS_TO_DEGS;
        float roll = orientation[2] * FROM_RADS_TO_DEGS;
        ((TextView)findViewById(R.id.pitch)).setText("Pitch: "+pitch);
        ((TextView)findViewById(R.id.roll)).setText("Roll: "+roll);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
