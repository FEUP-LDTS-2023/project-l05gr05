package com.aor.pacxon.controller;

import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.LoaderArenaBuilder;
import com.aor.pacxon.model.MenuWinLevel;
import com.aor.pacxon.states.GameState;
import com.aor.pacxon.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuWinLevelControllerTest {
    private MenuWinLevelController menuWinLevelController;
    private MenuWinLevel menuWinLevelMock;

    @BeforeEach
    public void setUp() {
        menuWinLevelMock = mock(MenuWinLevel.class);
        menuWinLevelController = new MenuWinLevelController(menuWinLevelMock);
    }

    @Test
    public void testStep_SelectNextLevelAction() throws IOException {
        // Testa se a seleção de avançar para o próximo nível leva ao estado do segundo nível do jogo
        Game gameMock = mock(Game.class);
        LoaderArenaBuilder loaderArenaBuilderMock = mock(LoaderArenaBuilder.class);
        when(loaderArenaBuilderMock.createArena()).thenReturn(null);
        when(menuWinLevelMock.isSelectedNextLevel()).thenReturn(true);

        menuWinLevelController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(GameState.class));
    }

    @Test
    public void testStep_SelectBackToMenuAction() throws IOException {
        // Testa se a seleção de voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuWinLevelMock.isSelectedBackToMenu()).thenReturn(true);

        menuWinLevelController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_MoveUpAction() throws IOException {
        // Testa se a ação de mover para cima na interface do menu funciona corretamente
        menuWinLevelController.step(null, GUI.ACTION.UP, 100L);
        verify(menuWinLevelMock).previousEntry();
    }

    @Test
    public void testStep_MoveDownAction() throws IOException {
        // Testa se a ação de mover para baixo na interface do menu funciona corretamente
        menuWinLevelController.step(null, GUI.ACTION.DOWN, 100L);
        verify(menuWinLevelMock).nextEntry();
    }
}
