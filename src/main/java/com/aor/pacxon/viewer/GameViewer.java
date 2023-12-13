package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Position;
import com.aor.pacxon.model.Arena;
import com.aor.pacxon.model.ObjectType;
import com.aor.pacxon.viewer.Viewer;


import java.util.List;

import static java.lang.Math.round;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {

        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getPacman(), new PacmanViewer());
        drawElements(gui, getModel().getCoins(), new CoinViewer());
        gui.drawText(new Position(0, 0), "Lives: " + getModel().getPacman().getLives(), "#FFD700");
        gui.drawText(new Position(25, 0), "Level: " + round(getModel().getLevel()), "#FFD700");
        gui.drawText(new Position(53,0), "Points: " + round(getModel().getPacman().getPoints()), "#FFD700");
    }

    private <T extends ObjectType> void drawElements(GUI gui, List<T> elements, ObjectViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends ObjectType> void drawElement(GUI gui, T element, ObjectViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
