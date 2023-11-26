package com.aor.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuHTPTest {
    //Verifica se a criação de um objeto MenuHTP atribui corretamente o número de entradas e se a única entrada está corretamente selecionada por padrão
    @Test
    void testInitialization() {
        MenuHTP menu = new MenuHTP();
        assertEquals(1, menu.getNumberEntries());
        assertTrue(menu.isSelectedBackToMenu());
    }

    //Verifica se o método getEntry retorna corretamente a string da entrada esperada
    @Test
    void testGetEntry() {
        MenuHTP menu = new MenuHTP();
        assertEquals("BACK TO MENU", menu.getEntry(0));
    }

    //Verifica se o método isSelected retorna verdadeiro para a entrada corretamente selecionada
    @Test
    void testIsSelected() {
        MenuHTP menu = new MenuHTP();
        assertTrue(menu.isSelectedBackToMenu());
    }

    //Verifica se o método getCurrentEntry retorna corretamente o índice da entrada atual
    @Test
    void testGetCurrentEntry() {
        MenuHTP menu = new MenuHTP();
        assertEquals(0, menu.getCurrentEntry()); // Por default, a primeira entry é selcionada
    }
}
