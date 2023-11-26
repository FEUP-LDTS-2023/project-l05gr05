package com.aor.pacxon.states;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.Game;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private final T model;

    private final Viewer<T> viewer;

    private final Controller<T> controller;



    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}

