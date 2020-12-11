package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity implements Runnable {
    private RecyclerView recyclerView;
    private List<Data> list = new ArrayList<>();
    private DataAdapter dataAdapter = new DataAdapter(list);
    private int count;
    TextView A2_TextView_1;
    private static int number = 30;

    private Handler mainHandler;
    private TextView mTextView;
    private Thread mThread;
    private boolean mflag;
    private int mCount = 30;
    private Button bt_boom;
    private TextView t1;
    private TextView t2;
    private TextView t3;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menufristpage, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     /*   count=list.size();
        switch (item.getItemId()){
            case R.id.item_add:
                if(count%2==0){
                list.add(new Data("newtext",R.drawable.lovely1));
                }else {
                list.add(new Data("newtext",R.drawable.p5));
                }
                dataAdapter.notifyItemChanged(0);
                Toast.makeText(Activity2.this, "你添加了一项", Toast.LENGTH_SHORT).show();break;
            case R.id.item_remove:
                list.remove(0);
                dataAdapter.notifyItemRemoved(0);
                Toast.makeText(Activity2.this, "你删除了一项", Toast.LENGTH_SHORT).show();break;
            default:break;
        }*/
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        t3=findViewById(R.id.A2_textView_xia);bt_boom=findViewById(R.id.bt_boom);t1=findViewById(R.id.A2_textView_l);t3=findViewById(R.id.A2_textView_shang);

        mainHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int what = msg.what;
                switch (what) {
                    case 1:
        bt_boom.setVisibility(View.GONE);

        mTextView.setVisibility(View.VISIBLE);
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
                        int arg1 = msg.arg1;
                        Log.d("Kodulf", "Handler arg1=" + arg1);
                        Log.d("Kodulf", "TestView  =" + mTextView.getText().toString());
                        mTextView.setText(String.valueOf(arg1));
                        break;
                   case 2 :
                        bt_boom.setVisibility(View.VISIBLE);
                        mTextView.setVisibility(View.VISIBLE);
                        t1.setVisibility(View.GONE);
                        t2.setVisibility(View.GONE);
                        t3.setVisibility(View.GONE);
                        break;
                }
            }
        };

        mTextView = (TextView) findViewById(R.id.A2_textView_k);
        mThread = new Thread(this);
    }


    public void btnDaoJiShi(View view) {
        Log.d("Kodulf", "mThread state" + mThread.getState());
        Log.d("Kodulf", "mThread toString" + mThread.toString());
        if (!mThread.isAlive()) {
            mflag = true;

            if (mThread.getState() == Thread.State.TERMINATED) {
                mThread = new Thread(this);
                if (mCount == -1) mCount = 30;
                mThread.start();
            } else {
                mThread.start();
            }
        } else {
            mflag = false;
        }
    }

    @Override
    public void run() {
        while (mflag && mCount >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (mCount==0){
                Message message = Message.obtain();
                message.what = 2;
                mainHandler.sendMessage(message);
                Log.d("Kodulf", "end");
            }else{
            Message message = Message.obtain();
            message.what = 1;
            message.arg1 = mCount;
            mainHandler.sendMessage(message);
            Log.d("Kodulf", "mCount=" + mCount--);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mflag = false;
    }

}
       /* recyclerView=findViewById(R.id.recyclerview_1);

        recyclerView.addItemDecoration(new SpacesItemDecoration(10));

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);

        list.add(new Data("text1",R.drawable.ic_launcher_foreground));
        list.add(new Data("text2",R.drawable.lovely1));
        list.add(new Data("text3",R.drawable.ic_launcher_background));
        list.add(new Data("text4",R.drawable.pig));
        list.add(new Data("text5",R.drawable.ic_launcher_background));
        list.add(new Data("text6",R.drawable.p1));
        list.add(new Data("text7",R.drawable.ic_launcher_foreground));
        list.add(new Data("text8",R.drawable.p2));
        list.add(new Data("text9",R.drawable.ic_launcher_foreground));
        list.add(new Data("text10",R.drawable.monstar1));
        list.add(new Data("text11",R.drawable.ic_launcher_foreground));
        list.add(new Data("text12",R.drawable.monstar2));
        list.add(new Data("text13",R.drawable.ic_launcher_foreground));
        list.add(new Data("text14",R.drawable.yundong));
        list.add(new Data("text15",R.drawable.ic_launcher_foreground));
        list.add(new Data("text16",R.drawable.fee));
        list.add(new Data("text17",R.drawable.ic_launcher_foreground));

        dataAdapter.notifyDataSetChanged();*/
