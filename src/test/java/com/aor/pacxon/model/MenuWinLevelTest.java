package com.aor.pacxon.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MenuWinLevelTest {
    //Verifica se a criação de um objeto MenuWinLevel atribui corretamente os pontos e se o número de entradas e a primeira entrada selecionada estão corretos por padrão
    @Test
    void testInitialization() {
        MenuWinLevel menu = new MenuWinLevel(100);
        assertEquals(100, menu.getPoints());
        assertEquals(2, menu.getNumberEntries());
        assertTrue(menu.isSelectedNextLevel());
        assertFalse(menu.isSelectedBackToMenu());
    }

    //Verifica se a chamada ao método nextEntry avança corretamente para a próxima entrada, alterando o estado de seleção conforme esperado
    @Test
    void testNextEntry() {
        MenuWinLevel menu = new MenuWinLevel(100);
        menu.nextEntry();
        assertFalse(menu.isSelectedNextLevel());
        assertTrue(menu.isSelectedBackToMenu());
    }


    //Verifica se a chamada ao método previousEntry retrocede corretamente para a entrada anterior, alterando o estado de seleção conforme esperado
    @Test
    void testPreviousEntry() {
        MenuWinLevel menu = new MenuWinLevel(100);
        menu.previousEntry();
        assertFalse(menu.isSelectedNextLevel());
        assertTrue(menu.isSelectedBackToMenu());
    }


    //Verifica se o método getEntry retorna corretamente as strings das entradas esperadas
    @Test
    void testGetEntry() {
        MenuWinLevel menu = new MenuWinLevel(100);
        assertEquals("NEXT LEVEL", menu.getEntry(0));
        assertEquals("BACK TO MENU", menu.getEntry(1));
    }


    //Verifica se o método isSelected retorna verdadeiro para a entrada corretamente selecionada e falso para a não selecionada
    @Test
    void testIsSelected() {
        MenuWinLevel menu = new MenuWinLevel(100);
        assertTrue(menu.isSelectedNextLevel());
        assertFalse(menu.isSelectedBackToMenu());

        menu.nextEntry();
        assertFalse(menu.isSelectedNextLevel());
        assertTrue(menu.isSelectedBackToMenu());
    }

}
