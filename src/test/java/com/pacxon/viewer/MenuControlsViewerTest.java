package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.MenuControls;
import com.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class MenuControlsViewerTest {

    @Mock
    private GUI mockGui;

    private MenuControlsViewer viewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewer = new MenuControlsViewer(new MenuControls());
    }

    @Test
    void testDrawControlsMenu() {
        viewer.drawElements(mockGui);

        verify(mockGui).drawText(new Position(5, 5), "RETURN TO MAIN MENU", "#FFA500");
        verify(mockGui).drawText(new Position(5, 7), "UP ARROW - MOVE UP", "#FFFFFF");
        verify(mockGui).drawText(new Position(5, 8), "DOWN ARROW - MOVE DOWN", "#FFFFFF");
        verify(mockGui).drawText(new Position(5, 9), "LEFT ARROW - MOVE LEFT", "#FFFFFF");
        verify(mockGui).drawText(new Position(5, 10), "RIGHT ARROW - MOVE RIGHT", "#FFFFFF");
        verify(mockGui).drawText(new Position(5, 12), "Q - RETURN TO MAIN MENU", "#FFFFFF");
    }
}
