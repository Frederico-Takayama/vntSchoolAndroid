package com.takayama.aula9desafio.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.takayama.aula9desafio.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter{

    public List<Music> musicList;
    public ItemClickListener onItemClickListener;

    public MusicAdapter(List<Music> musicList, ItemClickListener onItemClickListener) {
        this.musicList = musicList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_musics, parent, false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Music music = musicList.get(position);

        if(holder instanceof MusicViewHolder) {
            MusicViewHolder musicViewHolder = (MusicViewHolder) holder;
            musicViewHolder.bind(music, onItemClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }
}
