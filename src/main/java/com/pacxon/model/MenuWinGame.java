package com.pacxon.model;

import java.util.Arrays;
import java.util.List;

public class MenuWinGame {
    private final List<String> entries;
    private int currentEntry = 0;
    private int points;

    public MenuWinGame(int points) {
        this.points = points;
        this.entries = Arrays.asList( "LEVEL 1", "BACK TO MENU");
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

    public boolean isSelectedNextLevel() {
        return isSelected(0);
    }

    public boolean isSelectedBackToMenu() {
        return isSelected(1);
    }


    public int getPoints() {
        return points;
    }
}
