package com.example.tp4moviles.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Llamada extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentLlamada = new Intent(Intent.ACTION_CALL);
        intentLlamada.setData(Uri.parse("tel:" + "2664935442"));
        intentLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentLlamada);
    }
}
