package com.pacxon.viewer;

import com.pacxon.model.Pacman;
import com.pacxon.gui.GUI;

public class PacmanViewer implements ObjectViewer<Pacman> {
    @Override
    public void draw(Pacman pacman, GUI gui) {
        gui.drawPacman(pacman.getPosition());
    }
}
