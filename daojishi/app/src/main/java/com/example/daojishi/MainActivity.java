package com.example.daojishi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Runnable{
    private Handler mainHandler;
    private TextView mTextView;
    private Thread mThread;
    private boolean mflag;
    private int mCount = 30;
    private Button bt_boom;
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private Button bt_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t3=findViewById(R.id.A2_textView_xia);
        bt_boom=findViewById(R.id.bt_boom);
        bt_2=findViewById(R.id.M_bt);
        t1=findViewById(R.id.A2_textView_l);
        t3=findViewById(R.id.A2_textView_shang);

        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,second.class);
                startActivity(intent);
            }
        });

        mainHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int what = msg.what;
                switch (what){
                    case 1:
                        int arg1 = msg.arg1;
                        Log.d("Kodulf","Handler arg1="+arg1);
                        Log.d("Kodulf", "TestView  =" + mTextView.getText().toString());
                        mTextView.setText(String.valueOf(arg1));
                        break;
                }
            }
        };

        mTextView=(TextView)findViewById(R.id.A2_textView_k);

        mThread = new Thread(this);
    }

    public void btnDaoJiShi(View view) {
        Log.d("Kodulf","mThread state"+mThread.getState());
        Log.d("Kodulf","mThread toString"+mThread.toString());

        if(!mThread.isAlive()){
            mflag=true;
            if(mThread.getState()==Thread.State.TERMINATED){
                mThread = new Thread(this);
                if(mCount==-1) mCount=30;
                mThread.start();
            }else{
                mThread.start();
            }
        }else {
            mflag=false;
        }
    }


    @Override
    public void run() {

        while(mflag&&mCount>=0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = Message.obtain();
            message.what=1;
            message.arg1=mCount;
            mainHandler.sendMessage(message);
            Log.d("Kodulf","mCount="+mCount--);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mflag=false;
    }

}