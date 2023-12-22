package com.pacxon.states;

import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuWinLevelController;
import com.pacxon.model.MenuWinLevel;
import com.pacxon.viewer.MenuWinLevelViewer;
import com.pacxon.viewer.Viewer;

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