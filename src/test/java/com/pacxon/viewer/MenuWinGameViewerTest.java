package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.MenuWinGame;
import com.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MenuWinGameViewerTest {
    private MenuWinGameViewer menuWinGameViewer;
    private GUI gui;
    private MenuWinGame menu;

    @BeforeEach
    public void setUp() {
        menu = mock(MenuWinGame.class);
        menuWinGameViewer = new MenuWinGameViewer(menu);
        gui = mock(GUI.class);
    }

    @Test
    // Testa se o método drawElements desenha corretamente a mensagem de vitória "!!!YOU WON!!!" na posição (5, 5) com a cor #FFA500
    public void testDrawElements_Title() {
        menuWinGameViewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 5), "!!!YOU WON!!!", "#FFA500");
    }

    @Test
    // Testa se o método drawElements desenha corretamente as entradas do menu na posição e cor adequada
    public void testDrawElements_MenuEntries() {
        // Configuração do Mock para o número de entradas e seus textos correspondentes
        when(menu.isSelected(0)).thenReturn(true);
        when(menu.isSelected(1)).thenReturn(false);
        when(menu.getEntry(0)).thenReturn("Option A");
        when(menu.getEntry(1)).thenReturn("Option B");

        menuWinGameViewer.drawElements(gui);

        // Verifica se as entradas do menu estão sendo desenhadas corretamente com as cores adequadas
        verify(gui).drawText(new Position(5, 7), "Option A", "#FFD700"); // Verifica se a primeira entrada é desenhada selecionada
        verify(gui).drawText(new Position(5, 8), "Option B", "#FFFFFF"); // Verifica se a segunda entrada é desenhada não selecionada
    }
}
