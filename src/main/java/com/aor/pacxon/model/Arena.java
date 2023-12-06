package com.aor.pacxon.model;

import com.aor.pacxon.model.Position;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Wall;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Pacman pacman;
    private List<Position> trail;

    private List<Monster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.trail = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public void addToTrail(Position position) {
        if (isEmpty(position)) {
            trail.add(position);
        }
    }
    public List<Position> getTrail() {
        return trail;
    }
    public void clearTrail() {
        trail.clear();
    }

    public void fillArea(List<Position> trail) {
        // Implementação simplificada do algoritmo de preenchimento de área
        for (Position pos : trail) {
            // Suponha que temos um método para adicionar paredes
            addWallAtPosition(pos);
        }
    }

    private void addWallAtPosition(Position position) {
        if (isEmpty(position)) {
            walls.add(new Wall(position.getX(), position.getY()));
        }
    }

    public void checkCollisionsWithTrail() {
        for (Monster monster : monsters) {
            if (trail.contains(monster.getPosition())) {
                // Pac-Man perde uma vida e o rasto é limpo
                pacman.decreaseLives();
                clearTrail();
                // Reinicie a posição do Pac-Man, se necessário
            }
        }
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
