package com.aor.pacxon.model;

import java.util.Arrays;
import java.util.List;

public class MenuHTP {
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuHTP() {
        this.entries = Arrays.asList("BACK TO MENU");
    }


    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public int getNumberEntries(){
        return entries.size();
    }

    public boolean isSelectedBackToMenu() {
        return isSelected(0);
    }

    public boolean isSelectedBackToMenuA() {
        return isSelected(0);
    }

    public int getCurrentEntry() {
        return currentEntry;
    }
}
