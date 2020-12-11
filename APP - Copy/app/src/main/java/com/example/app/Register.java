package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private EditText et_re_password;
    private String name_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button = (Button) findViewById(R.id.button8);
        Button button1 = (Button) findViewById(R.id.button7);
        et_username = (EditText) findViewById(R.id.editText);
        et_password = (EditText) findViewById(R.id.editText3);
        et_re_password = (EditText) findViewById(R.id.editText5);

        et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        et_re_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String re_password = et_re_password.getText().toString().trim();
                name_key = et_username.getText().toString().trim();
                switch (v.getId()) {
                    case R.id.button7:
                        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                            Toast.makeText(Register.this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                        } else {
                            if (password.equals(re_password)) {
                                if (isExistUserName(username)) {
                                    Toast.makeText(Register.this, "此账户名已经存在", Toast.LENGTH_SHORT).show();
                                } else {
                                    SharedPreferences.Editor save_data = getSharedPreferences("user_data", MODE_PRIVATE).edit();
                                    save_data.putString(username, password);
                                    save_data.apply();
                                    Toast.makeText(Register.this, "注册成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            } else {
                                Toast.makeText(Register.this, "两次输入的密码不同", Toast.LENGTH_LONG).show();
                            }
                        }
                    default:
                        break;
                }
            }
        });
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

