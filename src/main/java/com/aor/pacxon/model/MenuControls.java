package com.aor.pacxon.model;

import java.util.Arrays;
import java.util.List;

public class MenuControls {
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuControls() {
        this.entries = Arrays.asList("BACK TO MENU");
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedBackToMenu() {
        return isSelected(0);
    }

    public boolean isSelectedBackToMenuA() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

}
