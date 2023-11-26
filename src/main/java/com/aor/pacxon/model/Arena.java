package com.aor.pacxon.model;

import com.aor.pacxon.model.Position;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Pacman pacman;


    private List<Monster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}
