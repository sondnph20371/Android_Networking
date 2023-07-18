package com.example.myapplication.Buoi5;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class Album_Adapter extends RecyclerView.Adapter<Album_Adapter.AlbumViewHolder> {
    private Context context;
    private ArrayList<Album> list;

    public Album_Adapter(Context context, ArrayList<Album> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.album_item, parent, false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.tvId.setText(list.get(position).getId());
        holder.tvTitle.setText(list.get(position).getTitle());
        String imgUrl = list.get(position).getUrl();
        Picasso.get().load(imgUrl).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tvId, tvTitle;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.item_iv);
            tvId = itemView.findViewById(R.id.item_tvId);
            tvTitle = itemView.findViewById(R.id.item_tvTitle);
        }
    }



}
