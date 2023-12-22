package com.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuControlsTest {

    //Verifica se a criação de um objeto MenuControls atribui corretamente o número de entradas e se a única entrada está corretamente selecionada por padrão
    @Test
    void testInitialization() {
        MenuControls menu = new MenuControls();
        assertEquals(1, menu.getNumberEntries());
        assertTrue(menu.isSelectedBackToMenu());
    }

    //Verifica se o método getEntry retorna corretamente a string da entrada esperada
    @Test
    void testGetEntry() {
        MenuControls menu = new MenuControls();
        assertEquals("BACK TO MENU", menu.getEntry(0));
    }

    //Verifica se o método isSelected retorna verdadeiro para a entrada corretamente selecionada
    @Test
    void testIsSelected() {
        MenuControls menu = new MenuControls();
        assertTrue(menu.isSelectedBackToMenu());
    }
}
