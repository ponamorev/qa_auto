package org.example.patterns.structural.composite;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class SongGroup extends SongComponent {
    private final List<SongComponent> songComponents = new ArrayList<>();
    @Getter
    private final String groupName;
    @Getter
    private final String groupDescription;

    public SongGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    @Override
    public void add(SongComponent songComponent) {
        songComponents.add(songComponent);
    }

    @Override
    public void remove(SongComponent songComponent) {
        songComponents.remove(songComponent);
    }

    @Override
    public SongComponent getSongComponent(int componentIndex) {
        return songComponents.get(componentIndex);
    }

    @Override
    public void displaySongInfo() {
        System.out.println(getGroupName() + " " + getGroupDescription() + "\n");

        for (SongComponent songInfo : songComponents) {
            songInfo.displaySongInfo();
        }
    }
}
