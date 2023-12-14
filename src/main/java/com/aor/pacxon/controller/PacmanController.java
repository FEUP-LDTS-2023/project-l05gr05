package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.*;
import com.aor.pacxon.Game;
import com.aor.pacxon.states.DieState;

import java.util.ArrayList;
import java.util.List;

public class PacmanController extends GameController {
    private final List<Position> pathVertices = new ArrayList<>();
    public PacmanController(Arena arena) {
        super(arena);
        pathVertices.add(arena.getPacman().getPosition());
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
        Position currentPosition = arena.getPacman().getPosition();

        if (!position.equals(currentPosition) && !arena.isEmpty(position)) {
            pathVertices.add(currentPosition); // Adiciona um vértice quando muda de direção
            arena.fillPolygon(pathVertices); // Chama o método para preencher o polígono
            pathVertices.clear();
            pathVertices.add(position); // Inicia um novo rastreamento a partir da nova posição
        }


        if (arena.isEmpty(position)) {
            pathVertices.add(position);
            arena.addToTrail(position);
        } else {
            if (!arena.getTrail().isEmpty()) {
                pathVertices.add(currentPosition);
                arena.fillPolygon(pathVertices);
                pathVertices.clear();
                arena.clearTrail();
            }
            pathVertices.add(position);
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
        if (getModel().getPacman().isDead())
            game.setState(new DieState((new MenuDie())));
        if (action == GUI.ACTION.UP) movePacmanUp();
        if (action == GUI.ACTION.RIGHT) movePacmanRight();
        if (action == GUI.ACTION.DOWN) movePacmanDown();
        if (action == GUI.ACTION.LEFT) movePacmanLeft();
    }
}