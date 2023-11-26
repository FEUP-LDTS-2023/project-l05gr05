package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.MenuDie;
import com.aor.pacxon.model.Position;

public class MenuDieViewer extends Viewer<MenuDie>{
    public MenuDieViewer(MenuDie menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(5, 5), "GAME OVER", "#FFA500");

        for (int i = 0; i < 2; i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
