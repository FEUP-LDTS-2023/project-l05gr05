package com.aor.pacxon.model;

import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Wall;

import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setPacman(createPacman());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Pacman createPacman();

}
