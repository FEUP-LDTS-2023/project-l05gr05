package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.gui.GUI;
import com.pacxon.model.LoaderArenaBuilder;
import com.pacxon.model.Menu;
import com.pacxon.model.MenuWinGame;
import com.pacxon.states.GameState;
import com.pacxon.states.MenuState;

import java.io.IOException;

public class MenuWinGameController extends Controller<MenuWinGame>{
    public MenuWinGameController(MenuWinGame menu) {
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
                if (getModel().isSelectedNextLevel()) game.setState(new GameState(new LoaderArenaBuilder("1", getModel().getPoints()).createArena()));
                if (getModel().isSelectedBackToMenu()) game.setState(new MenuState(new Menu()));
        }
    }
}
