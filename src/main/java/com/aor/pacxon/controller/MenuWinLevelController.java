package com.aor.pacxon.controller;

import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.LoaderArenaBuilder;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.MenuWinLevel;
import com.aor.pacxon.states.GameState;
import com.aor.pacxon.states.MenuState;

import java.io.IOException;

public class MenuWinLevelController extends Controller<MenuWinLevel>{

    public MenuWinLevelController(MenuWinLevel menu) {
        super(menu);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedNextLevel()){
                    game.setState(new GameState(new LoaderArenaBuilder(2).createArena()));
                }
                if (getModel().isSelectedBackToMenu()) game.setState(new MenuState(new Menu()));
        }
    }
}
