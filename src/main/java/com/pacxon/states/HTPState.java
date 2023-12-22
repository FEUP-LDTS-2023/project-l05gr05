package com.pacxon.states;

import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuHTPController;
import com.pacxon.model.MenuHTP;
import com.pacxon.viewer.MenuHTPViewer;
import com.pacxon.viewer.Viewer;

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