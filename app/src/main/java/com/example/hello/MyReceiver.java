package com.example.hello;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.Gravity;
import android.widget.Toast;

import java.lang.reflect.GenericArrayType;

public class MyReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        Toast toast = Toast.makeText(context, "Your batterey is low", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(5000);
        throw new UnsupportedOperationException("Not yet Implemented");
    }

}
