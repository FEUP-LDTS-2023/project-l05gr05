package com.pacxon.states;

import com.pacxon.model.Arena;
import com.pacxon.controller.ArenaController;
import com.pacxon.controller.Controller;
import com.pacxon.viewer.Viewer;
import com.pacxon.viewer.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
