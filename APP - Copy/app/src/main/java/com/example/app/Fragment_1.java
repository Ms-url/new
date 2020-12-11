package com.example.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_1 extends Fragment {
    private View view;
    //
    private RecyclerView recyclerView;
    private List<Data> list=new ArrayList<>();
    private DataAdapter dataAdapter=new DataAdapter(list);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_1, container, false);

        recyclerView=view.findViewById(R.id.recyclerview_1);

        recyclerView.addItemDecoration(new SpacesItemDecoration(10));

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);
    list.clear();
        list.add(new Data("text1",R.drawable.sport1));
        list.add(new Data("text2",R.drawable.sport2));
        list.add(new Data("text3",R.drawable.sport3));
        list.add(new Data("text4",R.drawable.sport4));
        list.add(new Data("text5",R.drawable.sport5));
        list.add(new Data("text6",R.drawable.sport6));
        list.add(new Data("text7",R.drawable.sport7));
        list.add(new Data("text8",R.drawable.sport7));
        list.add(new Data("text9",R.drawable.sport6));
        list.add(new Data("text10",R.drawable.sport5));
        list.add(new Data("text11",R.drawable.sport4));
        list.add(new Data("text12",R.drawable.sport3));
        list.add(new Data("text13",R.drawable.sport2));
        list.add(new Data("text14",R.drawable.sport1));
        list.add(new Data("text15",R.drawable.sport7));
        list.add(new Data("text16",R.drawable.ic_launcher_background));
        list.add(new Data("text17",R.drawable.ic_launcher_foreground));

        return view;
    }
}