package com.example.seven;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Url_1_GET extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Url_get_data> list=new ArrayList<>();
    private RecyclerView_data_Adaper dataAdapter=new RecyclerView_data_Adaper(list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_e_t);

        recyclerView=findViewById(R.id.Url_get_RecyclerView);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));

        JsonDataGet(   );
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);
        list.clear();

    }

    private void JsonDataGet(String jsonData){
        try{
            JSONObject jsonObject=new JSONObject(jsonData);
            JSONObject jsonObjectData=jsonObject.getJSONObject("data");
            JSONArray jsonArray_Datas=jsonObjectData.getJSONArray("datas");
            for(int i=0;i<jsonData.length();i++){
                JSONObject jsonObjectk=jsonArray_Datas.getJSONObject(i);
                String title=jsonObjectk.getString("title");
                String shower=jsonObjectk.getString("shower");
                String link=jsonObjectk.getString("link");
                list.add(new Url_get_data(title,shower,link));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}