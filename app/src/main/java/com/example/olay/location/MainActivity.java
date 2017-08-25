package com.example.olay.location;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView textView, textView1, erro;
    private static final String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        textView1 = (TextView) findViewById(R.id.textview1);
        erro = (TextView) findViewById(R.id.text);
        LLocationManager lLocationManager = new LLocationManager(this);
        lLocationManager.setTime(10);
        lLocationManager.setDistance(10);
        lLocationManager.setType(MyLocation.GPS);
        lLocationManager.setListener(new LLocation() {
            @Override
            public void OnSuccess(LocationData locationData) {
                textView.setText(locationData.getType() + "," + locationData.getStatellites());
                textView1.setText("精度:" + locationData.getLocation().getLatitude());
                Log.e(TAG, "OnSuccess: " + locationData.toString());
            }

            @Override
            public void OnFailed(int error) {
                erro.setText("错误代码:" + error);
                Log.e(TAG, "OnFailed: " + error);
            }
        });

        lLocationManager.startService();
    }
}
