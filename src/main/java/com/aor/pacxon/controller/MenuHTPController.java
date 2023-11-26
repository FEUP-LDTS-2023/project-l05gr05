package com.aor.pacxon.controller;

import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.MenuHTP;
import com.aor.pacxon.states.HTPState;
import com.aor.pacxon.states.MenuState;

import java.io.IOException;

public class MenuHTPController extends Controller<MenuHTP>{

    public MenuHTPController(MenuHTP menu) {
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
