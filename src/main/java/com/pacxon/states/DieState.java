package com.pacxon.states;

import com.pacxon.controller.Controller;
import com.pacxon.controller.MenuDieController;
import com.pacxon.model.MenuDie;
import com.pacxon.viewer.MenuDieViewer;
import com.pacxon.viewer.Viewer;

public class DieState extends State<MenuDie>{
    public DieState(MenuDie m){
        super(m);
    }

    @Override
    protected Viewer<MenuDie> getViewer() {
        return new MenuDieViewer(getModel());
    }

    @Override
    protected Controller<MenuDie> getController() {
        return new MenuDieController(getModel());
    }
}
