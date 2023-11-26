package com.aor.pacxon.model;

import java.util.List;

public class Pacman extends ObjectType {
    private int energy;

    public Pacman(int x, int y) {
        super(x, y);
        this.energy = 10;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public float getEnergy() {
        return energy;
    }
}
