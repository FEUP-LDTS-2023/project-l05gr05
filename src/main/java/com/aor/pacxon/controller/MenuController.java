package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.Game;
import com.aor.pacxon.model.*;
import com.aor.pacxon.states.ControlsState;
import com.aor.pacxon.states.GameState;
import com.aor.pacxon.states.HTPState;
import com.aor.pacxon.states.MenuState;

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
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}
