package com.aor.pacxon.viewertest;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.MenuWinLevel;
import com.aor.pacxon.model.Position;
import com.aor.pacxon.viewer.MenuWinLevelViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    /**
    @Test
    public void testDrawElements() {
        // Testa se o método drawElements() desenha corretamente a mensagem "!!!YOU WON!!!" na posição (5, 5) em amarelo (#FFA500)
        // Também verifica se as entradas do menu são desenhadas corretamente com as cores apropriadas
        menuWinLevelViewer.drawElements(gui);
        verify(gui).drawText(eq(new Position(5, 5)), eq("!!!YOU WON!!!"), eq("#FFA500"));

        // Verifica se o método drawText() é chamado para desenhar as entradas do menu
        verify(gui, times(2)).drawText(any(Position.class), anyString(), anyString());
    }
    */
}
