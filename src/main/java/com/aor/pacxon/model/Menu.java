package com.aor.pacxon.model;

import com.aor.pacxon.MusicSound;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    private final MusicSound menuMusic;

    public Menu() {
        this.entries = Arrays.asList( "PLAY","HOW TO PLAY", "CONTROLS", "QUIT");
        this.menuMusic = new MusicSound("music file path");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public boolean isSelectedControls(){return isSelected(2);}

    public boolean isSelectedHTP(){return isSelected(1);}

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public void playMenuMusic() {
        menuMusic.play();
    }

    public void stopMenuMusic() {
        menuMusic.stop();
    }
}
