package com.aor.pacxon.model;

import java.util.List;

public class Pacman extends ObjectType {
    private int lives;

    public Pacman(int x, int y) {
        super(x, y);
        this.lives = 3;
    }

    public boolean isDead(){
        if (lives==0){
            return true;
        }
        return false;
    }


    public void decreaseLives() {
        if (this.lives > 0) {
            this.lives--;
        }
    }

    public float getLives() {
        return lives;
    }

}
