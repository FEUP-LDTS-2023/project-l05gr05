package com.pacxon.states;

import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuControlsController;
import com.pacxon.model.MenuControls;
import com.pacxon.viewer.MenuControlsViewer;
import com.pacxon.viewer.Viewer;

public class ControlsState extends State<MenuControls>{
    public ControlsState(MenuControls m){
        super(m);
    }

    @Override
    protected Viewer<MenuControls> getViewer() {
        return new MenuControlsViewer(getModel());
    }

    @Override
    protected Controller<MenuControls> getController() {
        return new MenuControlsController(getModel());
    }
}