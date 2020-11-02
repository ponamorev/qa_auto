package org.example.patterns.structural.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Song extends SongComponent {
    private final String songName;
    private final String bandName;
    private final int releaseYear;

    @Override
    public void displaySongInfo() {
        System.out.println(getSongName() + " was recorded by " + getBandName() +
                " in " + getReleaseYear());
    }
}
