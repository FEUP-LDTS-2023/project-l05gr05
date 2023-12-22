package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.gui.GUI;
import com.pacxon.model.MenuHTP;
import com.pacxon.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuHTPControllerTest {
    private MenuHTPController menuHTPController;
    private MenuHTP menuHTPMock;

    @BeforeEach
    public void setUp() {
        menuHTPMock = mock(MenuHTP.class);
        menuHTPController = new MenuHTPController(menuHTPMock);
    }

    @Test
    public void testStep_SelectBackToMenuAction() throws IOException {
        // Testa se a seleção de voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuHTPMock.isSelectedBackToMenu()).thenReturn(true);

        menuHTPController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_QuitBackToMenuAction() throws IOException {
        // Testa se a ação de sair e voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuHTPMock.isSelectedBackToMenuA()).thenReturn(true);

        menuHTPController.step(gameMock, GUI.ACTION.QUIT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }
}
