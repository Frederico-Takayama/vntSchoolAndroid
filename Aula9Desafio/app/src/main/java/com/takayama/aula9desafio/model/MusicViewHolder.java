package com.takayama.aula9desafio.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.takayama.aula9desafio.R;


public class MusicViewHolder extends RecyclerView.ViewHolder{

    public MusicViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void bind(Music music, ItemClickListener itemClickListener) {
        TextView titleView = itemView.findViewById(R.id.title);
        TextView timeView = itemView.findViewById(R.id.time);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onClick(music);
            }
        });

        titleView.setText(music.getTitle());
        timeView.setText(music.getTime());
    }
}
