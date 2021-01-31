package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder>{
    private List<RvData> list;

    public RvAdapter(List<RvData> list){
        this.list=list;
    }

    class RvViewHolder extends RecyclerView.ViewHolder{
        public TextView tvRV;
        //
        public View data_view;

        public RvViewHolder(@NonNull View itemView){
            super(itemView);
            //
            data_view=itemView;
            tvRV=itemView.findViewById(R.id.rv_rv);
        }
    }
    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // return new RvViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_rv,parent,false));
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_1,parent,false);
        final RvViewHolder holder=new RvViewHolder(view);
        holder.data_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"you click ",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder( RvViewHolder holder, int position) {
        RvData rvData=list.get(position);
        holder.tvRV.setText(rvData.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
