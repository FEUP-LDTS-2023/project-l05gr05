package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.MenuHTP;
import com.pacxon.model.Position;

public class MenuHTPViewer extends Viewer<MenuHTP>{
    public MenuHTPViewer(MenuHTP menu) {super(menu);}

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(5, 5), "RETURN TO MAIN MENU", "#FFA500");
        gui.drawText(new Position(5, 7), "In this game you play as a pacman who tries to conquer the map", "#FFFFFF");
        gui.drawText(new Position(5, 8), "while the monsters try to stop you by chasing you! RUUUNNNN!!!", "#FFFFFF");
        gui.drawText(new Position(5, 9), "The main  goal is to be the owner of  80% of the map in  order", "#FFFFFF");
        gui.drawText(new Position(5, 10),"to progress to a new level all the while trying to avoid being", "#FFFFFF");
        gui.drawText(new Position(5, 11),"hit by the monsters.", "#FFFFFF");
        gui.drawText(new Position(5, 13),"Good luck and have fun!", "#FFFFFF");

    }
}