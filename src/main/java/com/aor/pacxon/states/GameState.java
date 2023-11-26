package com.aor.pacxon.states;

import com.aor.pacxon.model.Arena;
import com.aor.pacxon.controller.ArenaController;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.viewer.Viewer;
import com.aor.pacxon.viewer.GameViewer;

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
