package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.*;
import com.aor.pacxon.Game;
import com.aor.pacxon.states.DieState;

public class PacmanController extends GameController {
    public PacmanController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getPacman().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getPacman().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getPacman().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getPacman().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPacman().setPosition(position);
            if (getModel().isMonster(position)) getModel().getPacman().decreaseEnergy();
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}