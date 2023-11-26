package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.MenuControls;
import com.aor.pacxon.model.Position;

public class MenuControlsViewer extends Viewer<MenuControls>{
    public MenuControlsViewer(MenuControls menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(5, 5), "RETURN TO MAIN MENU", "#FFA500");
        gui.drawText(new Position(5, 7), "UP ARROW - MOVE UP", "#FFFFFF");
        gui.drawText(new Position(5, 8), "DOWN ARROW - MOVE DOWN", "#FFFFFF");
        gui.drawText(new Position(5, 9), "LEFT ARROW - MOVE LEFT", "#FFFFFF");
        gui.drawText(new Position(5, 10), "RIGHT ARROW - MOVE RIGHT", "#FFFFFF");
        gui.drawText(new Position(5, 12), "Q - RETURN TO MAIN MENU", "#FFFFFF");
    }
}