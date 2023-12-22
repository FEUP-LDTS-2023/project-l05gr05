package com.pacxon.controller;

import com.pacxon.gui.GUI;
import com.pacxon.model.Arena;
import com.pacxon.model.Monster;
import com.pacxon.model.Position;
import com.pacxon.Game;

import java.io.IOException;

public class MonsterController extends GameController {
    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters())
                moveMonster(monster, monster.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }

    private void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getPacman().getPosition().equals(position))
                getModel().getPacman().decreaseLives();
        }
    }
}
