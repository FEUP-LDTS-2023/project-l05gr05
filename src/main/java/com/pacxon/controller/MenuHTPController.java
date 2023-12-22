package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.gui.GUI;
import com.pacxon.model.Menu;
import com.pacxon.model.MenuHTP;
import com.pacxon.states.MenuState;

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
