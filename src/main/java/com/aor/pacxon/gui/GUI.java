package com.aor.pacxon.gui;

import com.aor.pacxon.model.Position;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public interface GUI {
    void drawCoin(Position position);
    ACTION getNextAction() throws IOException;

    void drawPacman(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
