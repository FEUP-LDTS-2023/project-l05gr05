package com.aor.pacxon.model;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private int level;
    private Pacman pacman;


    private List<Monster> monsters;
    private List<Wall> walls;
    public Arena(int width, int height, int level) {
        this.width = width;
        this.height = height;
        this.level = level;
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

    public boolean wallHit() {
        int x = getPacman().getPosition().getX();
        int y = getPacman().getPosition().getY()-1;
        Position position = new Position(x, y);
        Position position1 = new Position(x, y + 1);
        Position position2 = new Position(x, y - 1);
        Position position3 = new Position(x + 1, y);
        Position position4 = new Position(x - 1, y);

        for (Wall wall : walls) {
            if (wall.getPosition().equals(position)||wall.getPosition().equals(position1)||wall.getPosition().equals(position2)||wall.getPosition().equals(position3)||wall.getPosition().equals(position4)) {
                walls.remove(wall);
                return true;
            }
        }
        return false;
    }

    public boolean monsterHit() {
        int x = getPacman().getPosition().getX();
        int y = getPacman().getPosition().getY()-1;
        Position position = new Position(x, y);
        Position position1 = new Position(x, y + 1);
        Position position2 = new Position(x, y - 1);
        Position position3 = new Position(x + 1, y);
        Position position4 = new Position(x - 1, y);
        for(Monster monster: monsters){
            if (monster.getPosition().equals(position)||monster.getPosition().equals(position1)||monster.getPosition().equals(position2)||monster.getPosition().equals(position3)||monster.getPosition().equals(position4)) {
                monster.setAlive(false);
                monsters.remove(monster);
                return true;
            }
        }
        return false;
    }

    public boolean pacmanHit(){
        int x = getPacman().getPosition().getX();
        int y = getPacman().getPosition().getY()-1;
        Position position = new Position(x, y);
        Position position1 = new Position(x, y + 1);
        Position position2 = new Position(x, y - 1);
        Position position3 = new Position(x + 1, y);
        Position position4 = new Position(x - 1, y);

        if (getPacman().getPosition().equals(position)||getPacman().getPosition().equals(position1)||getPacman().getPosition().equals(position2)||getPacman().getPosition().equals(position3)||getPacman().getPosition().equals(position4)) {
            pacman.setEnergy(0);
            return true;
        }
        return false;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel(){
        return level;
    }
}
