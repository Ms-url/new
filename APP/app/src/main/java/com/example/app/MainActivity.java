package com.example.app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    private static EditText et_username;
    private static EditText et_password;
    private String key;
    private int i = 0;
    protected boolean useThemestatusBarColor = false;
    protected boolean useStatusBarColor = true;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String returnData1 = data.getStringExtra("data1");
            String returnData2 = data.getStringExtra("data2");
            Log.d("a", returnData1);
            et_username.setText(returnData1);
            et_password.setText(returnData2);
        } else if (resultCode == RESULT_CANCELED) {
            String returnData3 = data.getStringExtra("data3");
            String returnData4 = data.getStringExtra("data4");
            Log.d("a", returnData3);
            et_username.setText(returnData3);
            et_password.setText(returnData4);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        et_username = (EditText) findViewById(R.id.editText1);
        et_password = (EditText) findViewById(R.id.editText2);
        Button bt_register = (Button) findViewById(R.id.button6);
        Button bt_login = (Button) findViewById(R.id.button1);
       // Button bt_forget = (Button) findViewById(R.id.button4);
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);
        CheckBox checkboxpass = (CheckBox) findViewById(R.id.checkBox2);
            //实现沉浸式状态栏
            setStatusBar();

        TextView ti=findViewById(R.id.textView6);
        ti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"暂无其他登录方式",Toast.LENGTH_SHORT).show();
            }
        });


        et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        checkboxpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString().trim();
                String password = et_password.getText().toString().trim();

                SharedPreferences sp = getSharedPreferences("user_data", MODE_PRIVATE);
                key = sp.getString(username, "");

                switch (v.getId()) {
                    case R.id.button1:
                        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                            //Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                            //startActivity(intent);
                            Toast.makeText(MainActivity.this, "账号和密码不能为空", Toast.LENGTH_LONG).show();
                        } else if (checkbox.isChecked()) {
                            if (TextUtils.isEmpty(key)) {
                                Toast.makeText(MainActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                            } else if (key.equals(password)) {
                                Intent intent = new Intent(MainActivity.this, Frist.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "请先同意用户协议", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        TextView tit=findViewById(R.id.textView2);
        tit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Forget.class);
                startActivityForResult(intent, 1);
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
        }}
}
