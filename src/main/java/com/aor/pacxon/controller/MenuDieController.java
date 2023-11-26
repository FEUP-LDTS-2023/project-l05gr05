package com.aor.pacxon.controller;

import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.MenuDie;
import com.aor.pacxon.states.MenuState;

import java.io.IOException;

public class MenuDieController  extends Controller<MenuDie> {
    public MenuDieController(MenuDie menu) {
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
                if (getModel().isSelectedBackToMenu()) game.setState(new MenuState(new Menu()));
                if (getModel().isSelectedExit()) game.setState(null);
        }
    }
}