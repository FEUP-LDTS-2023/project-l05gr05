package com.pacxon.viewer;

import com.pacxon.model.Pacman;
import com.pacxon.gui.GUI;
import com.pacxon.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class PacmanViewerTest {

    @Test
    public void testDrawPacman() {

        GUI gui = Mockito.mock(GUI.class);
        PacmanViewer pacmanViewer = new PacmanViewer();
        int x = 3;
        int y = 3;
        Position position = new Position(x, y);
        Pacman pacman = new Pacman(x, y);
        pacmanViewer.draw(pacman, gui);
        verify(gui).drawPacman(position);
    }
}

