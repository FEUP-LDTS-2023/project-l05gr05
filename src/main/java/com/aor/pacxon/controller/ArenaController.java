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
        if (action == GUI.ACTION.QUIT || getModel().getPacman().getLives() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            pacmanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}