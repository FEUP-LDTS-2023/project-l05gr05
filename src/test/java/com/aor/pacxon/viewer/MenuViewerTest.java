package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MenuViewerTest {
    private MenuViewer menuViewer;
    private GUI gui;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        menu = mock(Menu.class);
        menuViewer = new MenuViewer(menu);
        gui = mock(GUI.class);
    }

    @Test
    // Testa se o método drawElements desenha corretamente as entradas do menu nas posições e cores adequadas
    public void testDrawElements_MenuEntries() {
        // Configuração do Mock para o número de entradas e seus textos correspondentes
        when(menu.getNumberEntries()).thenReturn(3);
        when(menu.isSelected(0)).thenReturn(true);
        when(menu.isSelected(1)).thenReturn(false);
        when(menu.isSelected(2)).thenReturn(false);
        when(menu.getEntry(0)).thenReturn("Option 1");
        when(menu.getEntry(1)).thenReturn("Option 2");
        when(menu.getEntry(2)).thenReturn("Option 3");

        menuViewer.drawElements(gui);

        // Verifica se as entradas do menu estão sendo desenhadas corretamente com as cores adequadas
        verify(gui).drawText(new Position(5, 7), "Option 1", "#FFD700"); // Verifica se a primeira entrada é desenhada selecionada
        verify(gui).drawText(new Position(5, 8), "Option 2", "#FFFFFF"); // Verifica se a segunda entrada é desenhada não selecionada
        verify(gui).drawText(new Position(5, 9), "Option 3", "#FFFFFF"); // Verifica se a terceira entrada é desenhada não selecionada
    }
}
