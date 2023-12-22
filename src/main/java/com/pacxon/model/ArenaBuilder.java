package com.pacxon.model;

import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setCoin(createCoin());
        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setLevel(getLevel());
        arena.getPacman().setPoints(getPoints());

        return arena;
    }

    protected abstract int getPoints();
    protected abstract int getLevel();
    protected abstract List<Coin> createCoin();
    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Pacman createPacman();

}
