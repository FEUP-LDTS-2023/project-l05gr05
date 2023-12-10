package com.aor.pacxon.model;

import java.util.List;

public class Pacman extends ObjectType {
    private int lives;

    private int points;
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

    public void setLives(int lives) {this.lives = lives;}

    public void addPointsByCoin(){
        this.points = this.points + 20;
    }

    public void setPoints(int points) {this.points = points;}

    public int getPoints() {return points;}
}
