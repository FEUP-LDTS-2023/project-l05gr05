package com.aor.pacxon.viewertest;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Position;
import com.aor.pacxon.model.Wall;
import com.aor.pacxon.viewer.WallViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class WallViewerTest {

    @Test
    public void testDraw() {
        Position position = new Position(10, 10);
        Wall wall = new Wall(10, 10);
        WallViewer wallViewer = new WallViewer();
        GUI gui = mock(GUI.class);
        wallViewer.draw(wall, gui);
        verify(gui).drawWall(position);
    }
}

