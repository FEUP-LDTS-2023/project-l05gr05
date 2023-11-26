package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.*;
import com.aor.pacxon.Game;
import com.aor.pacxon.states.DieState;

public class PacmanController extends GameController {

    private static int var = 0;
    private static boolean bool = false;
    private long lastBomb;

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
        Position position1 = new Position(getModel().getPacman().getPosition().getX(),getModel().getPacman().getPosition().getY()-1);
        moveHero(getModel().getPacman().getPosition().getUp());
    }

    public void moveHeroDown() {
        Position position1 = new Position(getModel().getPacman().getPosition().getX(),getModel().getPacman().getPosition().getY()+1);
        moveHero(getModel().getPacman().getPosition().getDown());
    }


    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPacman().setPosition(position);
            if (getModel().isMonster(position)) getModel().getPacman().decreaseEnergy();

        }
    }
}