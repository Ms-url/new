package com.example.app;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.VISIBLE;

public class Fragment_2 extends Fragment {
    private View view;
    private Button button1;
    private Button button2;
    private EditText editText;
    private ImageView imageView;
    private TextView textView;
    private int a;
    private String b;
    private String kong="";
    private int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2, container, false);

        button1 = view.findViewById(R.id.bt_jiecheng);
        button2 = view.findViewById(R.id.Determinant);
        textView = view.findViewById(R.id.tw_1);
        imageView = view.findViewById(R.id.iV);

        editText = view.findViewById(R.id.ed_jieche);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    try {
        if (TextUtils.isEmpty(editText.getText().toString())){
            //非空判断
        }else {
           a = Integer.parseInt(editText.getText().toString());
        }
                    textView.setVisibility(View.VISIBLE);
                        小V xiaov = new 小V();
                        long answer = xiaov.AccumlateCount(a);
                        if (a==0){
                            textView.setText(a + "! = 0" );
                        }else {
                        textView.setText(a + "! =" + answer);
                        }
                    } catch (Exception e) {
                        textView.setText("输入不合法");
                    }
                if (imageView.getVisibility() == VISIBLE) {
                    imageView.setVisibility(View.GONE);
                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             b = editText.getText().toString().trim();
                if (textView.getVisibility() == View.GONE) {
                    textView.setVisibility(View.VISIBLE);
                }
                if (imageView.getVisibility() == VISIBLE) {
                    imageView.setVisibility(View.GONE);
                }
                try {
                   // 小V xiaov = new 小V();
                   // double answer = xiaov.DeterminantCalculate(b,count/2);
                    textView.setText("暂无此功能");
                } catch (Exception e) {
                    textView.setText("输入不合法");
                }
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                count++;
                return false;
            }
        });

        return view;
    }
}
