package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.MenuWinLevel;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class MenuWinLevelViewerTest {
    private MenuWinLevelViewer menuWinLevelViewer;
    private GUI gui;
    private MenuWinLevel menuWinLevel;

    @BeforeEach
    public void setUp() {
        menuWinLevel = mock(MenuWinLevel.class);
        menuWinLevelViewer = new MenuWinLevelViewer(menuWinLevel);
        gui = mock(GUI.class);
    }
}
