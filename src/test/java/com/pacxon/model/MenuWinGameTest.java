package com.pacxon.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuWinGameTest {
    //Verifica se a criação de um objeto MenuWinGame atribui corretamente os pontos e se o número de entradas e a primeira entrada selecionada estão corretos por padrão
    @Test
    void testInitialization() {
        MenuWinGame menu = new MenuWinGame(200);
        assertEquals(200, menu.getPoints());
        assertEquals("LEVEL 1", menu.getEntry(0));
        assertEquals("BACK TO MENU", menu.getEntry(1));
        assertTrue(menu.isSelectedNextLevel());
        assertFalse(menu.isSelectedBackToMenu());
    }

    //Verifica se a chamada ao método nextEntry avança corretamente para a próxima entrada, alterando o estado de seleção conforme esperado
    @Test
    void testNextEntry() {
        MenuWinGame menu = new MenuWinGame(200);
        menu.nextEntry();
        assertFalse(menu.isSelectedNextLevel());
        assertTrue(menu.isSelectedBackToMenu());
    }


    //Verifica se a chamada ao método previousEntry retrocede corretamente para a entrada anterior, alterando o estado de seleção conforme esperado
    @Test
    void testPreviousEntry() {
        MenuWinGame menu = new MenuWinGame(200);
        menu.previousEntry();
        assertFalse(menu.isSelectedNextLevel());
        assertTrue(menu.isSelectedBackToMenu());
    }


    //Verifica se o método getEntry retorna corretamente as strings das entradas esperadas
    @Test
    void testGetEntry() {
        MenuWinGame menu = new MenuWinGame(200);
        assertEquals("LEVEL 1", menu.getEntry(0));
        assertEquals("BACK TO MENU", menu.getEntry(1));
    }


    //Verifica se o método isSelected retorna verdadeiro para a entrada corretamente selecionada e falso para a não selecionada
    @Test
    void testIsSelected() {
        MenuWinGame menu = new MenuWinGame(200);
        assertTrue(menu.isSelectedNextLevel());
        assertFalse(menu.isSelectedBackToMenu());

        menu.nextEntry();
        assertFalse(menu.isSelectedNextLevel());
        assertTrue(menu.isSelectedBackToMenu());
    }
}
