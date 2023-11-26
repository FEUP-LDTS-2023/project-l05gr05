package com.aor.pacxon.controller;

import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.MenuControls;
import com.aor.pacxon.states.ControlsState;
import com.aor.pacxon.states.MenuState;

import java.io.IOException;

public class MenuControlsController extends Controller<MenuControls>{

    public MenuControlsController(MenuControls menu) {
        super(menu);
    }



    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedBackToMenu())game.setState(new MenuState(new Menu()));
            case QUIT:
                if (getModel().isSelectedBackToMenuA())game.setState(new MenuState(new Menu()));
        }
    }
}