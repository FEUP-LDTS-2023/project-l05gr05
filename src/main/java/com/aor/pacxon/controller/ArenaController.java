package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.*;
import com.aor.pacxon.states.MenuState;
import com.aor.pacxon.Game;
import com.aor.pacxon.states.WinGameState;
import com.aor.pacxon.states.WinLevelState;

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
            game.setState(new MenuState(new Menu()));
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
        //adaptar quando for para meter a regra de 80% de preenchimento
    }
}