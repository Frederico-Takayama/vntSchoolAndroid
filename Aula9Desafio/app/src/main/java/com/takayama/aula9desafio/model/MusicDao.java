package com.takayama.aula9desafio.model;

import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    private static List<Music> musicList;

    public static List<Music> getMusicList() {
        musicList = new ArrayList<Music>();
        musicList.add(new Music("Hysteria", "00:00:00"));
        musicList.add(new Music("Undisclosed Desires", "00:03:47"));
        musicList.add(new Music("Knights of Cydonia", "00:07:43"));
        musicList.add(new Music("Psycho", "00:13:50"));
        musicList.add(new Music("Agitated", "00:19:06"));
        musicList.add(new Music("Assassin", "00:21:28"));
        musicList.add(new Music("Blackout", "00:24:59"));
        musicList.add(new Music("Animals", "00:29:21"));
        musicList.add(new Music("Bliss", "00:33:43"));
        musicList.add(new Music("Butterflies and Hurricanes", "00:37:54"));
        musicList.add(new Music("Dead Inside", "00:42:55"));
        musicList.add(new Music("Dead Star", "00:47:17"));
        musicList.add(new Music("Cave", "00:50:57"));
        musicList.add(new Music("Defector", "00:55:43"));
        musicList.add(new Music("Endlessly", "01:00:16"));
        musicList.add(new Music("Dig Down", "01:04:04"));
        musicList.add(new Music("Glorious", "01:07:52"));
        musicList.add(new Music("Hungry Like the Wolf", "01:12:33"));
        musicList.add(new Music("I Belong to You", "01:15:46"));
        musicList.add(new Music("Follow Me", "01:21:24"));
        musicList.add(new Music("Map of the Problematique", "01:25:14"));
        musicList.add(new Music("Mercy", "01:29:32"));
        musicList.add(new Music("Invincible", "01:33:24"));
        musicList.add(new Music("MK Ultra", "01:38:24"));
        musicList.add(new Music("Muscle Museum", "01:42:30"));
        musicList.add(new Music("Panic Station", "01:46:53"));
        musicList.add(new Music("New Born", "01:49:57"));
        musicList.add(new Music("Reapers", "01:56:00"));
        musicList.add(new Music("Pressure", "02:01:59"));
        musicList.add(new Music("Resistance", "02:05:54"));

        return musicList;
    }
}
