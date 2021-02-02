package com.example.wanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Register extends AppCompatActivity {
    private EditText editText_account;
    private EditText editText_password;
    private EditText editText_repassword;
    private Button button_register;
    private ImageView imageView_eye_password;
    private ImageView imageView_eye_repassword;
    private POST_Connection post_connection;
    private String responseData;
    private static int i = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editText_account = findViewById(R.id.edit_Register_account);
        editText_password = findViewById(R.id.edit_Register_password);
        editText_repassword = findViewById(R.id.edit_Register_repassword);
        button_register = findViewById(R.id.bt_Register);

        imageView_eye_password = findViewById(R.id.edit_eye);
        imageView_eye_repassword = findViewById(R.id.edit_eye);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//https://www.wanandroid.com/user/register

            }
        });

    }
}