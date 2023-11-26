package com.aor.pacxon.viewer;

import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.gui.GUI;

public class PacmanViewer implements ObjectViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        gui.drawHero(pacman.getPosition());
    }
}
