package com.aor.pacxon.states;

import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuControlsController;
import com.aor.pacxon.model.MenuControls;
import com.aor.pacxon.viewer.MenuControlsViewer;
import com.aor.pacxon.viewer.Viewer;

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