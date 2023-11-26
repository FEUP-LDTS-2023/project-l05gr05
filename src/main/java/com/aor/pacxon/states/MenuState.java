package com.aor.pacxon.states;

import com.aor.pacxon.controller.MenuController;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.viewer.MenuViewer;
import com.aor.pacxon.viewer.Viewer;

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
