package com.example.retrofitlibrary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<model> posts;

    public MyAdapter(List<model> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userId.setText(String.valueOf(posts.get(position).getUserId()));
        holder.Id.setText(String.valueOf(posts.get(position).getId()));
        holder.titleTextView.setText(posts.get(position).getTitle());
        holder.bodyTextView.setText(posts.get(position).getBody());


    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView bodyTextView;
        TextView userId;
        TextView Id;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tvTitle);
            bodyTextView = itemView.findViewById(R.id.tvbody);
            userId=itemView.findViewById(R.id.usrid);
           Id=itemView.findViewById(R.id.id);
        }
    }
}
