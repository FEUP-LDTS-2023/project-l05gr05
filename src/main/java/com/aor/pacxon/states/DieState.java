package com.aor.pacxon.states;

import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.controller.MenuDieController;
import com.aor.pacxon.model.MenuDie;
import com.aor.pacxon.viewer.MenuDieViewer;
import com.aor.pacxon.viewer.Viewer;

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
