package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<TextView>list1=new ArrayList<>();
    private PGAdapter pgAdapter=new PGAdapter(list1);

    private RecyclerView recyclerView;
    private List<RvData> list=new ArrayList<>();
    private RvAdapter rvAdapter=new RvAdapter(list);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //setFragment();

       /* RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);

        list.add(new RvData("text1"));
        list.add(new RvData("text2"));
        list.add(new RvData("text3"));
        list.add(new RvData("text4"));
        list.add(new RvData("text5"));
        list.add(new RvData("text6"));
        list.add(new RvData("text7"));
        list.add(new RvData("text8"));
        list.add(new RvData("text9"));
        list.add(new RvData("text10"));
        list.add(new RvData("text11"));
        list.add(new RvData("text12"));
        list.add(new RvData("text13"));
        list.add(new RvData("text14"));
        list.add(new RvData("text15"));
        list.add(new RvData("text16"));
        list.add(new RvData("text17"));
        list.add(new RvData("text18"));
        list.add(new RvData("text19"));
*/

        viewPager = findViewById(R.id.vp_demo);

        list1.add((TextView) LayoutInflater.from(this).inflate(R.layout.item_vp_1,null,false));
        list1.add((TextView) LayoutInflater.from(this).inflate(R.layout.item_vp_2,null,false));
        list1.add((TextView) LayoutInflater.from(this).inflate(R.layout.item_vp_3,null,false));
        viewPager.setAdapter(pgAdapter);
    }

    private void setFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.f_1,new Fragment_1()).commit();
    }
}