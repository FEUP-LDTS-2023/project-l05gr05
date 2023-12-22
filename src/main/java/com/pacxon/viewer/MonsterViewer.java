package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.Monster;


public class MonsterViewer implements ObjectViewer<Monster>{
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
