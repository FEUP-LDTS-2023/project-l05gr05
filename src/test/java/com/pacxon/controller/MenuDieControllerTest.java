package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.gui.GUI;
import com.pacxon.model.MenuDie;
import com.pacxon.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuDieControllerTest {
    private MenuDieController menuDieController;
    private MenuDie menuDieMock;

    @BeforeEach
    public void setUp() {
        menuDieMock = mock(MenuDie.class);
        menuDieController = new MenuDieController(menuDieMock);
    }

    @Test
    public void testStep_SelectBackToMenuAction() throws IOException {
        // Testa se a seleção de voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuDieMock.isSelectedBackToMenu()).thenReturn(true);

        menuDieController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_SelectExitAction() throws IOException {
        // Testa se a seleção de sair do jogo leva ao estado nulo do jogo
        Game gameMock = mock(Game.class);
        when(menuDieMock.isSelectedExit()).thenReturn(true);

        menuDieController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(null);
    }

    @Test
    public void testStep_MoveUpAction() throws IOException {
        // Testa se a ação de mover para cima na interface do menu funciona corretamente
        menuDieController.step(null, GUI.ACTION.UP, 100L);
        verify(menuDieMock).previousEntry();
    }

    @Test
    public void testStep_MoveDownAction() throws IOException {
        // Testa se a ação de mover para baixo na interface do menu funciona corretamente
        menuDieController.step(null, GUI.ACTION.DOWN, 100L);
        verify(menuDieMock).nextEntry();
    }
}
