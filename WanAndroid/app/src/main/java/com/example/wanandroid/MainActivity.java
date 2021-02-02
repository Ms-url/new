package com.example.wanandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText editText_account;
    private EditText editText_password;
    private Button button_register;
    private Button button_log_in;
    private ImageView imageView_eye;
    private ImageView imageView_user;
    private ImageView imageView_clock;
    private POST_Connection post_connection = new POST_Connection();
    private String responseData;
    private static int i = 2;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String m = (String) msg.obj;
                    Toast.makeText(MainActivity.this, m, Toast.LENGTH_SHORT).show();
                    Log.e("UIchange", "ui");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView_user = findViewById(R.id.im_log_in_username);
        imageView_clock = findViewById(R.id.im_log_in_clock);
        editText_account = findViewById(R.id.edit_LOGIN_account);
        editText_password = findViewById(R.id.edit_LOGIN_password);
        button_log_in = findViewById(R.id.bt_log_in);
        button_register = findViewById(R.id.bt_Register_intent);
        imageView_eye = findViewById(R.id.edit_eye);

        SharedPreferences.Editor save_data = getSharedPreferences("user_data", MODE_PRIVATE).edit();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        button_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText_account.getText().toString().trim();
                String password = editText_password.getText().toString().trim();
                Log.e("点击", "进入");

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "账号和密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("username", username);
                    map.put("password", password);
                    Log.e("分支", "进入");
                    new Thread(() -> {
                        Log.e("新线程", "开启");
                        try {
                            responseData = post_connection.sendGetNetRequest("https://www.wanandroid.com/user/login", map);
                            Log.e("返回值", responseData);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            JSONObject jsonObject = new JSONObject(responseData);
                            int jsonerrorCode = jsonObject.getInt("errorCode");

                            if (jsonerrorCode == -1) {
                                String jsonerrorMsg = jsonObject.getString("errorMsg");
                                showResponse(jsonerrorMsg);
                                Log.e("错误", "信息");
                            } else {
                                JSONObject jsonRightData = jsonObject.getJSONObject("data");
                                String jsonUsername = jsonRightData.getString("username");
                                int user_id = jsonRightData.getInt("id");

                                save_data.putString("username", username);
                                save_data.putString("password", password);
                                save_data.putInt("user_id", user_id);

                                Intent intent = new Intent(MainActivity.this, HomePage.class);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }

            }
        });


        editText_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        imageView_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i % 2 == 0) {
                    //如果选中，显示密码
                    imageView_eye.setImageResource(R.drawable.eye);
                    editText_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    i++;
                } else {
                    //否则隐藏密码
                    imageView_eye.setImageResource(R.drawable.closeeye);
                    editText_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    i++;
                }
            }
        });
    }

    private void showResponse(String st) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                message.obj = st;
                handler.sendMessage(message);
            }
        }).start();
    }
}
