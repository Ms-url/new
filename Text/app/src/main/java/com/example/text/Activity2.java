package com.example.text;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Data> list=new ArrayList<>();
    private DataAdapter dataAdapter=new DataAdapter(list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        recyclerView=findViewById(R.id.recyclerview_1);

        recyclerView.addItemDecoration(new SpacesItemDecoration(10));

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);

        list.add(new Data("text1",R.drawable.ic_launcher_foreground));
        list.add(new Data("text2",R.drawable.ic_launcher_background));
        list.add(new Data("text3",R.drawable.ic_launcher_background));
        list.add(new Data("text4",R.drawable.ic_launcher_background));
        list.add(new Data("text5",R.drawable.ic_launcher_background));
        list.add(new Data("text6",R.drawable.ic_launcher_background));
        list.add(new Data("text7",R.drawable.ic_launcher_foreground));
        list.add(new Data("text8",R.drawable.ic_launcher_background));
        list.add(new Data("text9",R.drawable.ic_launcher_foreground));
        list.add(new Data("text10",R.drawable.ic_launcher_background));
        list.add(new Data("text11",R.drawable.ic_launcher_foreground));
        list.add(new Data("text12",R.drawable.ic_launcher_background));
        list.add(new Data("text13",R.drawable.ic_launcher_foreground));
        list.add(new Data("text14",R.drawable.ic_launcher_background));
        list.add(new Data("text15",R.drawable.ic_launcher_foreground));
        list.add(new Data("text16",R.drawable.ic_launcher_background));
        list.add(new Data("text17",R.drawable.ic_launcher_foreground));

    }
}