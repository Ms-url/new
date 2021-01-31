package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Getpasswordback extends AppCompatActivity {
    private String user;
    private String pas;
    private String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getpasswordback);

        Button bt_1 = (Button) findViewById(R.id.button);
        Button bt_2 = (Button) findViewById(R.id.button10);
        Button bt_3 = (Button) findViewById(R.id.button11);
        Button bt_4 = (Button) findViewById(R.id.button9);

        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent = new Intent(Getpasswordback.this, MainActivity2.class);
                  startActivity(intent);
                Toast.makeText(Getpasswordback.this, "你可真是个小天才", Toast.LENGTH_SHORT).show();
                Toast.makeText(Getpasswordback.this, "可惜并没有这个功能", Toast.LENGTH_LONG).show();
                //finish();
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Getpasswordback.this, "是他是他就是他", Toast.LENGTH_SHORT).show();
            }
        });
        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Getpasswordback.this, "我不是，我没有", Toast.LENGTH_SHORT).show();
            }
        });
        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Getpasswordback.this, "这还是个谜", Toast.LENGTH_SHORT).show();
            }
        });

    }
}