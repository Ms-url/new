package com.example.wanandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
    protected boolean useThemestatusBarColor = false;
    protected boolean useStatusBarColor = true;
    private POST_Connection post_connection;
    private String responseData;
    private static int i = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_account = findViewById(R.id.edit_LOGIN_account);
        editText_password = findViewById(R.id.edit_LOGIN_password);
        button_log_in = findViewById(R.id.bt_log_in);
        button_register = findViewById(R.id.bt_register_intent);
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

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "账号和密码不能为空", Toast.LENGTH_LONG).show();
                } else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("username", username);
                    map.put("password", password);

                    new Thread(() -> {
                        responseData = post_connection.sendGetNetRequest("https://www.wanandroid.com/user/login", map);
                        try {
                            JSONObject jsonObject = new JSONObject(responseData);
                            int jsonerrorCode = jsonObject.getInt("errorCode");

                            if (jsonerrorCode == -1) {
                                String jsonerrorMsg = jsonObject.getString("errorMsg");
                                Toast.makeText(MainActivity.this, jsonerrorMsg, Toast.LENGTH_SHORT).show();

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

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.color_theme));//设置状态栏背景色
            } else {
                getWindow().setStatusBarColor(Color.TRANSPARENT);//透明
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        } else {
            Toast.makeText(this, "低于4.4的android系统版本不存在沉浸式状态栏", Toast.LENGTH_SHORT).show();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && useStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
}