package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.MenuWinLevel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import com.pacxon.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

class MenuWinLevelViewerTest {

    @Mock
    private GUI mockGui;

    @Mock
    private MenuWinLevel mockMenuWinLevel;

    private MenuWinLevelViewer viewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewer = new MenuWinLevelViewer(mockMenuWinLevel);
    }

    @Test
    void testDrawTitle() {
        viewer.drawElements(mockGui);
        verify(mockGui).drawText(new Position(5, 5), "!!!YOU WON!!!", "#FFA500");
    }

    @Test
    void testDrawMenuEntries() {
        when(mockMenuWinLevel.getEntry(0)).thenReturn("Entry 1");
        when(mockMenuWinLevel.getEntry(1)).thenReturn("Entry 2");
        when(mockMenuWinLevel.isSelected(0)).thenReturn(true);
        when(mockMenuWinLevel.isSelected(1)).thenReturn(false);

        viewer.drawElements(mockGui);

        verify(mockGui).drawText(new Position(5, 7), "Entry 1", "#FFD700");
        verify(mockGui).drawText(new Position(5, 8), "Entry 2", "#FFFFFF");
    }
}