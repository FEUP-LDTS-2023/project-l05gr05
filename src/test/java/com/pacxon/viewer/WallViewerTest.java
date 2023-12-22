package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.Position;
import com.pacxon.model.Wall;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class WallViewerTest {

    @Test
    public void testDraw() {
        Position position = new Position(10, 10);
        Wall wall = new Wall(10, 10, false);
        WallViewer wallViewer = new WallViewer();
        GUI gui = mock(GUI.class);
        wallViewer.draw(wall, gui);
        verify(gui).drawWall(position);
    }
}

