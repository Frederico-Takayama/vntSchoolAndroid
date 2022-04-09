package com.takayama.aula9desafio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.takayama.aula9desafio.model.ItemClickListener;
import com.takayama.aula9desafio.model.Music;
import com.takayama.aula9desafio.model.MusicAdapter;
import com.takayama.aula9desafio.model.MusicDao;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemClickListener onItemClickListener = new ItemClickListener() {
            @Override
            public void onClick(Music music) {
                Toast.makeText(MainActivity.this,
                        music.toString(), Toast.LENGTH_SHORT).show();

                //Chamando o youtube no momento da musica selecionada:
                try {
                    List<String> timeBuffer = Arrays.asList(music.getTime().split(":"));
                    Integer seconds = Integer.parseInt(timeBuffer.get(0))*3600
                            + Integer.parseInt(timeBuffer.get(1))*60
                            + Integer.parseInt(timeBuffer.get(2));

                    Intent i = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.youtube.com/watch?v=DuuOUyMrq_s&t=" + seconds));
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MusicAdapter musicAdapter = new MusicAdapter(MusicDao.getMusicList(), onItemClickListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(musicAdapter);
    }
}