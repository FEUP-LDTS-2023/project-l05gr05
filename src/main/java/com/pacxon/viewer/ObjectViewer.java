package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.ObjectType;

public interface ObjectViewer<T extends ObjectType> {

    void draw(T element, GUI gui);
}
