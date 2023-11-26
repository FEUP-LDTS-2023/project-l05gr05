package com.aor.pacxon.viewertest;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.MenuDie;
import com.aor.pacxon.model.Position;
import com.aor.pacxon.viewer.MenuDieViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MenuDieViewerTest {
    private MenuDieViewer menuDieViewer;
    private GUI gui;
    private MenuDie menuDie;

    @BeforeEach
    public void setUp() {
        menuDie = mock(MenuDie.class);
        menuDieViewer = new MenuDieViewer(menuDie);
        gui = mock(GUI.class);
    }

    @Test
    public void testDrawElementsGameOverText() {
        menuDieViewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 5), "GAME OVER", "#FFA500");
    }

    @Test
    public void testDrawElementsEntries() {
        // Define o comportamento esperado do MenuDie mock
        when(menuDie.getEntry(0)).thenReturn("Entry 1");
        when(menuDie.getEntry(1)).thenReturn("Entry 2");
        when(menuDie.isSelected(0)).thenReturn(true);
        when(menuDie.isSelected(1)).thenReturn(false);

        menuDieViewer.drawElements(gui);

        verify(gui).drawText(new Position(5, 7), "Entry 1", "#FFD700");
        verify(gui).drawText(new Position(5, 8), "Entry 2", "#FFFFFF");
    }
}
