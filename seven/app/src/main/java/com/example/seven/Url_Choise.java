package com.example.seven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Url_Choise extends AppCompatActivity {
private Button Url_ask_seven_homework;
private Button Url_ask_post_past;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utl__choise);

        Url_ask_seven_homework=findViewById(R.id.Url_ask_seven_homework);
        Url_ask_post_past=findViewById(R.id.Url_ask_post_past);

        Url_ask_seven_homework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Url_Choise.this,Url_1_GET.class);
                startActivity(intent);
            }
        });

        Url_ask_post_past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Url_Choise.this,Url_2_POST.class);
                startActivity(intent);
            }
        });
    }
}