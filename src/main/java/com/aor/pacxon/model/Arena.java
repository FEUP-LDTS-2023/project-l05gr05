package com.aor.pacxon.model;

import com.aor.pacxon.model.Position;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Wall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Arena {
    private final int width;
    private final int height;
    private int level;
    private Pacman pacman;
    private List<Coin> coins;
    private List<Position> trail;
    private Set<Position> filledPositions;

    private List<Monster> monsters;
    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.level = level;
        this.trail = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.filledPositions = new HashSet<>();
    }

    public void setCoin(List<Coin> coins) {this.coins = coins;}
    public List<Coin> getCoins() {return coins;}

    public class TemporaryWall extends Wall {
        public TemporaryWall(Position position) {
            super(position.getX(), position.getY(), true);
        }
    }

    public void convertTemporaryWallsToPermanent() {
        for (Wall wall : walls) {
            if (wall.isTemporary()) {
                wall.makePermanent();
            }
        }
    }
    public void addToTrail(Position position) {
        if (isEmpty(position)) {
            trail.add(position);
            walls.add(new TemporaryWall(position));
        }
    }
    public List<Position> getTrail() {
        return trail;
    }
    public void clearTrail() {
        trail.clear();
    }

    public void fillArea(Position start) {
        if (withinMapBounds(start) && isEmpty(start) && !filledPositions.contains(start)) {
            filledPositions.add(start);
            setWall(start);

            fillArea(new Position(start.getX() + 1, start.getY())); // Direita
            fillArea(new Position(start.getX() - 1, start.getY())); // Esquerda
            fillArea(new Position(start.getX(), start.getY() + 1)); // Abaixo
            fillArea(new Position(start.getX(), start.getY() - 1)); // Acima
        }
    }

    private void setWall(Position position) {
        if (withinMapBounds(position) && isEmpty(position)) {
            walls.add(new Wall(position.getX(), position.getY(), false)); // Adiciona parede permanente
        }
    }


    private boolean withinMapBounds(Position position) {
        return position.getX() >= 0 && position.getX() < width &&
                position.getY() >= 0 && position.getY() < height;
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

    public boolean hitCoin(){
        for (Coin coin : coins){
            if(coin.getPosition().equals(getPacman().getPosition())){
                coins.remove(coin);
                return true;
            }
        }
        return false;
    }
    public void removeCoin(Position position) {
        for(Coin coin: coins){
            if(coin.getPosition().equals(position)){
                coins.remove(coin);
            }

        }
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel(){
        return level;
    }

    public float calculateFillPercentage(){
        int totalTiles = width * height;
        int filledTiles = 0;

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                Position position = new Position(x, y);
                if(!isEmpty(position)){
                    filledTiles++;
                }
            }
        }
        return ((float) filledTiles / totalTiles) * 100;
    }
}
