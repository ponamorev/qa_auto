package org.example.patterns.structural.composite;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiscJockey {
    private final SongComponent songList;

    public void getSongList() {
        songList.displaySongInfo();
    }
}
