package com.example.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Data> mdataList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView dataImage;
        TextView dataText;

        public ViewHolder(View itemView) {
            super(itemView);
            dataImage=(ImageView) itemView.findViewById(R.id.data_image);
            dataText=(TextView) itemView.findViewById(R.id.data_text);
        }
    }

    public DataAdapter(List<Data> dataList) {
        mdataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_1_recyclerview_item,
                parent,false);
       final ViewHolder holder=new ViewHolder(view);
       holder.dataText.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = holder.getAdapterPosition();
               Data data = mdataList.get(position);
               Toast.makeText(v.getContext(),"你点了"+data.getName(),Toast.LENGTH_SHORT).show();
           }
       });holder.dataImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int position = holder.getAdapterPosition();
               Data data = mdataList.get(position);
               Toast.makeText(v.getContext(),"你点了"+data.getName()+"的图片",Toast.LENGTH_SHORT).show();
           }
       });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = mdataList.get(position);
        holder.dataImage.setImageResource(data.getImageId());
        holder.dataText.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return mdataList.size();
    }


}
