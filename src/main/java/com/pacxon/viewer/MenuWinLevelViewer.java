package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.MenuWinLevel;
import com.pacxon.model.Position;

public class MenuWinLevelViewer extends Viewer<MenuWinLevel>{
    public MenuWinLevelViewer(MenuWinLevel menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(5, 5), "!!!YOU WON!!!", "#FFA500");

        for (int i = 0; i < 2; i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
