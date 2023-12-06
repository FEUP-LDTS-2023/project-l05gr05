package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.*;
import com.aor.pacxon.Game;
import com.aor.pacxon.states.DieState;

public class PacmanController extends GameController {
    public PacmanController(Arena arena) {
        super(arena);
    }

    public void movePacmanLeft() {
        movePacman(getModel().getPacman().getPosition().getLeft());
    }

    public void movePacmanRight() {
        movePacman(getModel().getPacman().getPosition().getRight());
    }

    public void movePacmanUp() {
        movePacman(getModel().getPacman().getPosition().getUp());
    }

    public void movePacmanDown() {
        movePacman(getModel().getPacman().getPosition().getDown());
    }

    private void movePacman(Position position) {
        Arena arena = getModel();

        // Adiciona a posição ao rasto se for vazia (não é uma parede)
        if (arena.isEmpty(position)) {
            arena.addToTrail(position);
        } else {
            // Se atingir uma parede (posição não vazia), aciona o preenchimento da área
            if (!arena.getTrail().isEmpty()) {
                arena.fillArea(arena.getTrail());
                arena.clearTrail();
            }
        }
        boolean canMoveToPosition = getModel().isEmpty(position) || !getModel().isEmpty(position);

        boolean withinBounds = position.getX() >= 0 && position.getX() < getModel().getWidth() &&
                position.getY() >= 0 && position.getY() < getModel().getHeight();

        if (withinBounds && canMoveToPosition) {
            getModel().getPacman().setPosition(position);

            if (getModel().isMonster(position)) {
                getModel().getPacman().decreaseLives();
            }
        }
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePacmanUp();
        if (action == GUI.ACTION.RIGHT) movePacmanRight();
        if (action == GUI.ACTION.DOWN) movePacmanDown();
        if (action == GUI.ACTION.LEFT) movePacmanLeft();
    }
}