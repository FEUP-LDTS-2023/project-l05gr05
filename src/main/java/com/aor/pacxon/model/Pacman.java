package com.aor.pacxon.model;

import java.util.List;

public class Pacman extends ObjectType {
    private int energy;

    public Pacman(int x, int y) {
        super(x, y);
        this.energy = 3;
    }

    public boolean isDead(){
        if (energy==0){
            return true;
        }
        return false;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public float getEnergy() {
        return energy;
    }
}
