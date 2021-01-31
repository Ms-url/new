package com.example.text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   // private ViewPager viewPager;
   // private List<View> list=new ArrayList<>();
   // private viewPagerAdapter viewpageradapter=new viewPagerAdapter(list);
    TabLayout tabLayout;
    ViewPager viewPager;
    List<Fragment> fragmentList=new ArrayList<>();
    List<String> fragmentTitle=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button)findViewById(R.id.button2);
        Button button2=(Button)findViewById(R.id.button3);
        Button button3=(Button)findViewById(R.id.button4);
        tabLayout=findViewById(R.id.tabs_1);
        viewPager=findViewById(R.id.viewpager);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
            }
        });

        fragmentTitle.add("第一页");
        fragmentTitle.add("第二页");
        fragmentTitle.add("第三页");
        fragmentList.add(new Fragment_1());
        fragmentList.add(new Fragment_2());
        fragmentList.add(new Fragment_3());

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),
                ViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)) ;
        //将tablayout与viewpager联动
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
      /*  viewPager=findViewById(R.id.viewpager);
        list.add(LayoutInflater.from(this).inflate(R.layout.view_pager_item_1,null,false));
        list.add(LayoutInflater.from(this).inflate(R.layout.view_pager_item_2,null,false));
        list.add(LayoutInflater.from(this).inflate(R.layout.fragment_1,null,false));
        viewPager.setAdapter(viewpageradapter);*/
 }

class ViewPagerAdapter extends FragmentPagerAdapter{

    public ViewPagerAdapter( FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}}