package com.example.olay.location;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by OlAy on 2017/8/24.
 */

public class LLocationManager {
    private Activity mActivity;
    private String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION};
    private MyLocation myLocation;

    public LLocationManager(Activity activity) {
        mActivity = activity;
        getLocation();
        if (lacksPermission(permission[0])) {
            ActivityCompat.requestPermissions(mActivity, permission, 200);
            myLocation.startLocation();
        }
    }

    private void getLocation() {
        myLocation = MyLocation.getInstance(mActivity);
    }

    public void setTime(int time) {
        myLocation.setTime(time);
    }

    public void setDistance(int distance) {
        myLocation.setDistance(distance);
    }

    public void setType(String type) {
        myLocation.Type(type);
    }

    public void setListener(OnLocation onLocation) {
        myLocation.setOnLocation(onLocation);
    }

    public void startService() {
        mActivity.startService(new Intent(mActivity, MyService.class));
    }

    private boolean lacksPermission(String permission) {
        return ContextCompat.checkSelfPermission(mActivity, permission) ==
                PackageManager.PERMISSION_DENIED;
    }


}
