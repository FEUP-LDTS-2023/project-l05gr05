package com.pacxon.controller;

import com.pacxon.gui.GUI;
import com.pacxon.Game;
import com.pacxon.model.LoaderArenaBuilder;
import com.pacxon.model.Menu;
import com.pacxon.model.MenuControls;
import com.pacxon.model.MenuHTP;
import com.pacxon.states.ControlsState;
import com.pacxon.states.GameState;
import com.pacxon.states.HTPState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {

    public MenuController(Menu menu) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedControls()) game.setState(new ControlsState(new MenuControls()));
                if (getModel().isSelectedHTP()) game.setState(new HTPState(new MenuHTP()));
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder("1", 0).createArena()));
        }
    }
}
