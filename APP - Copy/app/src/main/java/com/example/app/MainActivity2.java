package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

//import android.annotation.SuppressLint;
//import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
//import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

//import java.io.IOException;
//import static com.example.secondblood.R.raw.mucis;

public class MainActivity2 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ImageButton bt_back=(ImageButton)findViewById(R.id.imageButton);
       // mediaPlayer = MediaPlayer.create(MainActivity2.this,R.raw.mucis);

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  play("R.raw.mucis");
                Toast.makeText(MainActivity2.this,"请重新输入",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

 /*   private void play(String path) {
        //播放之前要先把音频文件重置
        try {
            mediaPlayer.reset();
            //调用方法传进去要播放的音频路径
            mediaPlayer.setDataSource(path);
            //异步准备音频资源
            mediaPlayer.prepareAsync();
            //调用mediaPlayer的监听方法，音频准备完毕会响应此方法
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();//开始音频
                    Log.d("play","played");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}