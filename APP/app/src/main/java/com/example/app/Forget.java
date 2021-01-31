package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Forget extends AppCompatActivity {
private String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        Button button=(Button)findViewById(R.id.button2);//主键
        Button button2=(Button)findViewById(R.id.button5);//左键
        Button button3=(Button)findViewById(R.id.button3);//右键

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forget.this,Getpasswordback.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forget.this,MainActivity.class);
                intent.putExtra("data1","Trump");
                intent.putExtra("data2","20201122");
                if (isExistUserName("Trump")) {

                }
                else {
                SharedPreferences.Editor save_data = getSharedPreferences("user_data", MODE_PRIVATE).edit();
                save_data.putString("Trump","58674288");
                save_data.apply();
                }
                setResult(RESULT_OK,intent);
                Toast.makeText(Forget.this,"好的懂王",Toast.LENGTH_SHORT).show();
                finish();
                //startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Forget.this,MainActivity.class);
                intent.putExtra("data3","animal");
                intent.putExtra("data4","62437849");
                if (isExistUserName("animal")) {

                }
                else {
                SharedPreferences.Editor save_data = getSharedPreferences("user_data", MODE_PRIVATE).edit();
                save_data.putString("animal","62437849");
                save_data.apply();}
                setResult(RESULT_CANCELED,intent);
                Toast.makeText(Forget.this,"不愧是你",Toast.LENGTH_SHORT).show();
                finish();
                //startActivity(intent);
            }
        });
    }
    public void onBackPressed(){
        Intent intent=new Intent();
        intent.putExtra("data5"," ");
        setResult(RESULT_FIRST_USER,intent);
        finish();
    }

    private boolean isExistUserName(String name_key) {
        boolean has_userName = false;
        SharedPreferences sp = getSharedPreferences("user_data", MODE_PRIVATE);
        String spPsw = sp.getString(name_key, "");//传入用户名获取密码
        //如果密码不为空则确实保存过这个用户名
        if (!TextUtils.isEmpty(spPsw)) {
            has_userName = true;
        }
        return has_userName;
    }
}