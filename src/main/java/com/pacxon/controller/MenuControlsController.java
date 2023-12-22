package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.gui.GUI;
import com.pacxon.model.Menu;
import com.pacxon.model.MenuControls;
import com.pacxon.states.MenuState;

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