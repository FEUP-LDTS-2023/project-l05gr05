package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.Wall;

public class WallViewer implements ObjectViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
