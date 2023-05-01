package com.example.OrderedBroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverOne extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
        Log.i("MyReceiver", "自定义的广播接收者one， 接收到了广播事件");
    }
}

