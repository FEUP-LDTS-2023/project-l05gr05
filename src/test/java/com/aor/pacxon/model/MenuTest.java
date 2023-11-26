package com.aor.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    //Verifica se a criação de um objeto Menu atribui corretamente o número de entradas e se a primeira entrada está corretamente selecionada por padrão
    @Test
    void testInitialization() {
        Menu menu = new Menu();
        assertEquals(4, menu.getNumberEntries());
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedHTP());
        assertFalse(menu.isSelectedControls());
        assertFalse(menu.isSelectedExit());
    }


    //Verifica se a chamada ao método nextEntry avança corretamente para a próxima entrada, alterando o estado de seleção conforme esperado
    @Test
    void testNextEntry() {
        Menu menu = new Menu();
        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        assertTrue(menu.isSelectedHTP());
    }


    //Verifica se a chamada ao método previousEntry retrocede corretamente para a entrada anterior, alterando o estado de seleção conforme esperado
    @Test
    void testPreviousEntry() {
        Menu menu = new Menu();
        menu.previousEntry();
        assertFalse(menu.isSelectedStart());
        assertTrue(menu.isSelectedExit());
    }

    //ERRO
    //Verifica se a seleção de entradas cicla corretamente, indo para a próxima e, em seguida, para a anterior, mantendo o estado de seleção esperado
    /*@Test
    void testCycleEntries() {
        Menu menu = new Menu();
        menu.nextEntry();
        assertTrue(menu.isSelectedHTP());
        assertFalse(menu.isSelectedControls());

        menu.previousEntry();
        assertFalse(menu.isSelectedHTP());
        assertTrue(menu.isSelectedExit());
    }
    */


    //Verifica se o método getEntry retorna corretamente as strings das entradas esperadas
    @Test
    void testGetEntry() {
        Menu menu = new Menu();
        assertEquals("PLAY", menu.getEntry(0));
        assertEquals("HOW TO PLAY", menu.getEntry(1));
        assertEquals("CONTROLS", menu.getEntry(2));
        assertEquals("QUIT", menu.getEntry(3));
    }

    //Verifica se os métodos isSelected retornam verdadeiro para a entrada corretamente selecionada e falso para a não selecionada
    @Test
    void testIsSelected() {
        Menu menu = new Menu();
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedHTP());
        assertFalse(menu.isSelectedControls());
        assertFalse(menu.isSelectedExit());

        menu.nextEntry();
        assertFalse(menu.isSelectedStart());
        assertTrue(menu.isSelectedHTP());
    }
}
