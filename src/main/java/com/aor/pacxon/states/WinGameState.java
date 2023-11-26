package com.aor.pacxon.states;

import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuWinGameController;
import com.aor.pacxon.model.MenuWinGame;
import com.aor.pacxon.viewer.MenuWinGameViewer;
import com.aor.pacxon.viewer.Viewer;

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