package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Data> list=new ArrayList<>();
    private DataAdapter dataAdapter=new DataAdapter(list);
    private int count;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menufristpage,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        count=list.size();
        switch (item.getItemId()){
            case R.id.item_add:
                if(count%2==0){
                list.add(new Data("newtext",R.drawable.lovely1));
                }else {
                list.add(new Data("newtext",R.drawable.p5));
                }
                dataAdapter.notifyItemChanged(0);
                Toast.makeText(Activity2.this, "你添加了一项", Toast.LENGTH_SHORT).show();break;
            case R.id.item_remove:
                list.remove(0);
                dataAdapter.notifyItemRemoved(0);
                Toast.makeText(Activity2.this, "你删除了一项", Toast.LENGTH_SHORT).show();break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
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
        list.add(new Data("text2",R.drawable.lovely1));
        list.add(new Data("text3",R.drawable.ic_launcher_background));
        list.add(new Data("text4",R.drawable.pig));
        list.add(new Data("text5",R.drawable.ic_launcher_background));
        list.add(new Data("text6",R.drawable.p1));
        list.add(new Data("text7",R.drawable.ic_launcher_foreground));
        list.add(new Data("text8",R.drawable.p2));
        list.add(new Data("text9",R.drawable.ic_launcher_foreground));
        list.add(new Data("text10",R.drawable.monstar1));
        list.add(new Data("text11",R.drawable.ic_launcher_foreground));
        list.add(new Data("text12",R.drawable.monstar2));
        list.add(new Data("text13",R.drawable.ic_launcher_foreground));
        list.add(new Data("text14",R.drawable.yundong));
        list.add(new Data("text15",R.drawable.ic_launcher_foreground));
        list.add(new Data("text16",R.drawable.fee));
        list.add(new Data("text17",R.drawable.ic_launcher_foreground));

        dataAdapter.notifyDataSetChanged();
    }
}