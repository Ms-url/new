package com.example.wanandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class RecyclerViewAdaper_1 extends RecyclerView.Adapter<RecyclerViewAdaper_1.ViewHolder> {
    private List<UsefulData> mdata;

    static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View view){
            super(view);

        }
    }

    public RecyclerViewAdaper_1(List<UsefulData> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public RecyclerViewAdaper_1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdaper_1.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

}
