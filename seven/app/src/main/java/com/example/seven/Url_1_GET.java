package com.example.seven;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Url_1_GET extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Url_get_data> list = new ArrayList<>();
    private RecyclerView_data_Adaper dataAdapter = new RecyclerView_data_Adaper(list);

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Url_1_GET.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(dataAdapter);
                    Log.e("UIchange", "ui");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_e_t);

        recyclerView = findViewById(R.id.Url_get_RecyclerView);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        sendGetNetRequest("https://www.wanandroid.com/article/list/1/json");
        Log.e("connect", "ok");
       // JsonDataGet(responseData);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);
        list.clear();
        Log.e("finish", "finish");
    }

    private void sendGetNetRequest(String murl) {
        new Thread(() -> {
            try {
                URL url = new URL(murl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                connection.connect();
                InputStream in = connection.getInputStream();
                Log.e("send", "ok");

                String responseData = StreamToString(in);
                JsonDataGet(responseData);
                Log.e("jiexi", "解析");

                showResponse();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
                Log.e("time1", "请求超时");
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("time2", "请求超时");
            }
        }).start();
    }

    private String StreamToString(InputStream in) {
        StringBuilder sb = new StringBuilder();
        String oneLine;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            while ((oneLine = reader.readLine()) != null) {
                sb.append(oneLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private void JsonDataGet(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject jsonObjectData = jsonObject.getJSONObject("data");
            JSONArray jsonArray_Datas = jsonObjectData.getJSONArray("datas");
            for (int i = 0; i <jsonData.length(); i++) {
                JSONObject jsonObjectk = jsonArray_Datas.getJSONObject(i);
                String title = jsonObjectk.getString("title");
                String shower = jsonObjectk.getString("shareUser");
                String link = jsonObjectk.getString("link");
                list.add(new Url_get_data(title, shower, link));
                Log.e("kkkk", title);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showResponse() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }).start();
    }

}
      /*  runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Url_1_GET.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(dataAdapter);
                list.clear();
            }
        });*/
