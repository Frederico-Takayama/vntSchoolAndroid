package com.takayama.aula9desafio.model;

import androidx.annotation.NonNull;

public class Music {
    private String title;
    private String time;

    public Music(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    @NonNull
    @Override
    public String toString() {
        return title + " " + time;
//        return super.toString();
    }
}
