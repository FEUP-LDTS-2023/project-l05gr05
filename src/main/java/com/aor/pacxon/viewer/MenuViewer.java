package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.Position;

import java.net.URL;

public class MenuViewer extends Viewer<Menu> {

    public MenuViewer(Menu menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) {
        URL resource = getClass().getClassLoader().getResource("fonts/joystix monospace.otf");
        gui.drawText(new Position(5, 5), "PACXON", "#FFD700");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
