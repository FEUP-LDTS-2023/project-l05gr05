package com.aor.pacxon.controller;

import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.LoaderArenaBuilder;
import com.aor.pacxon.model.MenuWinGame;
import com.aor.pacxon.states.GameState;
import com.aor.pacxon.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuWinGameControllerTest {
    private MenuWinGameController menuWinGameController;
    private MenuWinGame menuWinGameMock;

    @BeforeEach
    public void setUp() {
        menuWinGameMock = mock(MenuWinGame.class);
        menuWinGameController = new MenuWinGameController(menuWinGameMock);
    }

    @Test
    public void testStep_SelectNextLevelAction() throws IOException {
        // Testa se a seleção de avançar para o próximo nível leva ao estado do próximo nível do jogo
        Game gameMock = mock(Game.class);
        LoaderArenaBuilder loaderArenaBuilderMock = mock(LoaderArenaBuilder.class);
        when(loaderArenaBuilderMock.createArena()).thenReturn(null);
        when(menuWinGameMock.isSelectedNextLevel()).thenReturn(true);

        menuWinGameController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(GameState.class));
    }

    @Test
    public void testStep_SelectBackToMenuAction() throws IOException {
        // Testa se a seleção de voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuWinGameMock.isSelectedBackToMenu()).thenReturn(true);

        menuWinGameController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_MoveUpAction() throws IOException {
        // Testa se a ação de mover para cima na interface do menu funciona corretamente
        menuWinGameController.step(null, GUI.ACTION.UP, 100L);
        verify(menuWinGameMock).previousEntry();
    }

    @Test
    public void testStep_MoveDownAction() throws IOException {
        // Testa se a ação de mover para baixo na interface do menu funciona corretamente
        menuWinGameController.step(null, GUI.ACTION.DOWN, 100L);
        verify(menuWinGameMock).nextEntry();
    }
}
