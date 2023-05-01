package com.example.OrderedBroadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.forhelp.R;

public class MainActivity extends AppCompatActivity {
    Button btn_sendOrderedBroadcast;
    private MyReceiverOne receiverOne;
    private MyReceiverTwo receiverTwo;
    private MyReceiverThree receiverThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册广播接收者
        registerReceiver();
        init();
    }
    private void registerReceiver(){
        //动态注册receiverOne广播
        receiverOne = new MyReceiverOne();
        IntentFilter filterOne = new IntentFilter();
        //设置广播的优先级别
        filterOne.setPriority(1000);
        filterOne.addAction("Intercept_Stitch");
        registerReceiver(receiverOne, filterOne);
        //动态注册receiverTwo广播
        receiverTwo = new MyReceiverTwo();
        IntentFilter filterTwo = new IntentFilter();
        //设置广播的优先级别
        filterTwo.setPriority(200);
        filterTwo.addAction("Intercept_Stitch");
        registerReceiver(receiverTwo, filterTwo);
        //动态注册receiverThree广播
        receiverThree = new MyReceiverThree();
        IntentFilter filterThree = new IntentFilter();
        //设置广播的优先级别
        filterThree.setPriority(600);
        filterThree.addAction("Intercept_Stitch");
        registerReceiver(receiverThree, filterThree);
    }
    public void init(){
        btn_sendOrderedBroadcast = findViewById(R.id.btn_sendOrderedBroadcast);
        btn_sendOrderedBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //定义广播的事件类型
                intent.setAction("Intercept_Stitch");
                //发送广播
                sendBroadcast(intent, null);
            }
        });
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(receiverOne);
        unregisterReceiver(receiverTwo);
        unregisterReceiver(receiverThree);
    }

}