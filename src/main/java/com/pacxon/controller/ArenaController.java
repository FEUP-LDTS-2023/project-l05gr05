package com.pacxon.controller;

import com.pacxon.gui.GUI;
import com.pacxon.model.*;
import com.pacxon.model.Arena;
import com.pacxon.model.MenuDie;
import com.pacxon.model.MenuWinGame;
import com.pacxon.model.MenuWinLevel;
import com.pacxon.states.DieState;
import com.pacxon.Game;
import com.pacxon.states.WinGameState;
import com.pacxon.states.WinLevelState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PacmanController pacmanController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        this.pacmanController = new PacmanController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPacman().getLives() == 0) {
            game.setState(new DieState(new MenuDie()));
            return; // Encerra a execução do método para evitar chamadas adicionais
        }
        pacmanController.step(game, action, time);
        monsterController.step(game, action, time);
        if(getModel().hitCoin()){
            getModel().getPacman().addPointsByCoin();
            getModel().removeCoin(getModel().getPacman().getPosition());
        }
        if (getModel().calculateFillPercentage() >= 80.0) {
            if (getModel().getLevel() == 1) {
                getModel().setLevel(getModel().getLevel() +1);
                game.setState(new WinLevelState(new MenuWinLevel(getModel().getPacman().getPoints())));
            } else if (getModel().getLevel() == 2) {
                getModel().setLevel(1);
                game.setState(new WinGameState(new MenuWinGame(getModel().getPacman().getPoints())));
            }
        }
    }
}