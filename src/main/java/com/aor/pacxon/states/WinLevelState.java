package com.aor.pacxon.states;

import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuWinLevelController;
import com.aor.pacxon.model.MenuWinLevel;
import com.aor.pacxon.viewer.MenuWinLevelViewer;
import com.aor.pacxon.viewer.Viewer;

public class WinLevelState extends State<MenuWinLevel>{
    public WinLevelState(MenuWinLevel m){
        super(m);
    }

    @Override
    protected Viewer<MenuWinLevel> getViewer() {
        return new MenuWinLevelViewer(getModel());
    }

    @Override
    protected Controller<MenuWinLevel> getController() {
        return new MenuWinLevelController(getModel());
    }
}