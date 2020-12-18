package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class boom extends AppCompatActivity {
    private TextView textView;
    private TextView textView3;
    private TextView textView8;
    private Button button;
    private int count = 30;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.d("count", String.valueOf(count));
                    textView.setText(String.valueOf(count)+" 秒");
                    break;
                case 2:
                    textView.setText(String.valueOf(30));
                    textView.setVisibility(View.GONE);
                    textView3.setVisibility(View.GONE);
                    textView8.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);
                    count=30;break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boom);

        textView = findViewById(R.id.S_textview_1);
        textView3 = findViewById(R.id.textView3);
        textView8 = findViewById(R.id.textView8);
        button = findViewById(R.id.S_button_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView8.setVisibility(View.VISIBLE);
                button.setVisibility(View.GONE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 30; i > -1; i--) {
                            count--;
                            Message message = new Message();
                            if (count<0){
                            message.what = 2;
                            }else {
                            message.what = 1;
                            }
                            handler.sendMessage(message);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}