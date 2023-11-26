package com.aor.pacxon.gui;

import com.aor.pacxon.model.Position;

import java.io.IOException;

public interface GUI {

    void close() throws IOException;

    void drawText(Position position, String menu, String s);

    void clear();

    void refresh() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

    ACTION getNextAction() throws IOException;

    void drawHero(Position position);

    void drawMonster(Position position);

    void drawWall(Position position);
}

