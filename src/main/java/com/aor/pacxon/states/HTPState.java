package com.aor.pacxon.states;

import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuHTPController;
import com.aor.pacxon.model.MenuHTP;
import com.aor.pacxon.viewer.MenuHTPViewer;
import com.aor.pacxon.viewer.Viewer;

public class HTPState extends State<MenuHTP>{
    public HTPState(MenuHTP m){
        super(m);
    }

    @Override
    protected Viewer<MenuHTP> getViewer() {
        return new MenuHTPViewer(getModel());
    }

    @Override
    protected Controller<MenuHTP> getController() {
        return new MenuHTPController(getModel());
    }
}