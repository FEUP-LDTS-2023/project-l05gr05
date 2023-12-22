package com.pacxon.states;

import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuWinGameController;
import com.pacxon.model.MenuWinGame;
import com.pacxon.viewer.MenuWinGameViewer;
import com.pacxon.viewer.Viewer;

public class WinGameState extends State<MenuWinGame> {
    public WinGameState(MenuWinGame m){
        super(m);
    }

    @Override
    protected Viewer<MenuWinGame> getViewer() {
        return new MenuWinGameViewer(getModel());
    }

    @Override
    protected Controller<MenuWinGame> getController() {
        return new MenuWinGameController(getModel());
    }
}