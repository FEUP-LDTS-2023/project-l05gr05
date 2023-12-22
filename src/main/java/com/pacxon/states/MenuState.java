package com.pacxon.states;

import com.pacxon.controller.MenuController;
import com.pacxon.controller.Controller;
import com.pacxon.model.Menu;
import com.pacxon.viewer.MenuViewer;
import com.pacxon.viewer.Viewer;

public class MenuState extends State<Menu> {

    public MenuState(Menu model){
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
