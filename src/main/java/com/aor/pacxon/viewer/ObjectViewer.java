package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.ObjectType;

public interface ObjectViewer<T extends ObjectType> {

    void draw(T element, GUI gui);
}
