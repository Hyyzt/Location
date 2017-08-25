package com.example.llocation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class YourService extends Service {
    private static final String TAG = "YourService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MyLocation myLocation = MyLocation.getInstance(getBaseContext());
        myLocation.startLocation();
        Log.e(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        YourService.this.startService(new Intent(YourService.this, MyService.class));
    }
}
