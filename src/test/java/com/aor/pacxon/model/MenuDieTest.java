package com.aor.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuDieTest {
    //Verifica se a criação de um objeto MenuDie atribui corretamente o número de entradas e se a primeira entrada está corretamente selecionada por padrão
    @Test
    void testInitialization() {
        MenuDie menu = new MenuDie();
        assertEquals(2, menu.getNumberEntries()); // Assuming two default entries
        assertTrue(menu.isSelectedBackToMenu()); // By default, the first entry is selected
        assertFalse(menu.isSelectedExit());
    }


    //Verifica se a chamada ao método nextEntry avança corretamente para a próxima entrada, alterando o estado de seleção conforme esperado
    @Test
    void testNextEntry() {
        MenuDie menu = new MenuDie();
        menu.nextEntry();
        assertFalse(menu.isSelectedBackToMenu());
        assertTrue(menu.isSelectedExit());
    }

    //Verifica se a chamada ao método previousEntry retrocede corretamente para a entrada anterior, alterando o estado de seleção conforme esperado
    @Test
    void testPreviousEntry() {
        MenuDie menu = new MenuDie();
        menu.previousEntry();
        assertFalse(menu.isSelectedBackToMenu());
        assertTrue(menu.isSelectedExit());
    }

    //Verifica se a seleção de entradas cicla corretamente, indo para a próxima e, em seguida, para a anterior, mantendo o estado de seleção esperado
    @Test
    void testCycleEntries() {
        MenuDie menu = new MenuDie();
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
        assertFalse(menu.isSelectedBackToMenu());

        menu.previousEntry();
        assertFalse(menu.isSelectedExit());
        assertTrue(menu.isSelectedBackToMenu());
    }

    //Verifica se o método getEntry retorna corretamente as strings das entradas esperadas
    @Test
    void testGetEntry() {
        MenuDie menu = new MenuDie();
        assertEquals("BACK TO MENU", menu.getEntry(0));
        assertEquals("QUIT", menu.getEntry(1));
    }

    //Verifica se os métodos isSelected retornam verdadeiro para a entrada corretamente selecionada e falso para a não selecionada
    @Test
    void testIsSelected() {
        MenuDie menu = new MenuDie();
        assertTrue(menu.isSelectedBackToMenu());
        assertFalse(menu.isSelectedExit());

        menu.nextEntry();
        assertFalse(menu.isSelectedBackToMenu());
        assertTrue(menu.isSelectedExit());
    }
}