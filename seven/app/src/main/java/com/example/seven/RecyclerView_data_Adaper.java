package com.example.seven;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_data_Adaper extends RecyclerView.Adapter<RecyclerView_data_Adaper.ViewHolder> {
    private List<Url_get_data> mdata;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView_title;
        TextView textView_show;
        TextView textView_link;

        public ViewHolder(View view){
            super(view);
            textView_link=(TextView)view.findViewById(R.id.item_link);
            textView_show=(TextView)view.findViewById(R.id.item_shower);
            textView_title=(TextView)view.findViewById(R.id.item_title);
        }
    }
    public RecyclerView_data_Adaper(List<Url_get_data> list){
        mdata=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup  parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.url_recyclerview_item,parent,false);

        final ViewHolder holder = new ViewHolder(view);
        holder.textView_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Url_get_data url_get_data = mdata.get(position);
                Log.e("weizhi", String.valueOf(position));
                String link = url_get_data.getLink();
                Log.e("mesge_link",link);
/////////////////////////////////////////////////////////////////////////////////
                Intent intent=new Intent(view.getContext(),web_activity.class);
                intent.putExtra("links",link);
                view.getContext().startActivity(intent);
/////////////////////////////////////////////////////////////////////////////////
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Url_get_data url_get_data=mdata.get(position);
        holder.textView_title.setText(url_get_data.getTitle());
        holder.textView_show.setText(url_get_data.getShower());
        holder.textView_link.setText(url_get_data.getLink());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
