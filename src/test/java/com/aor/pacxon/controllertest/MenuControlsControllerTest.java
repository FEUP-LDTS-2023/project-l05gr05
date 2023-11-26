package com.aor.pacxon.controllertest;

import com.aor.pacxon.controller.MenuControlsController;
import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.MenuControls;
import com.aor.pacxon.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControlsControllerTest {
    private MenuControlsController menuControlsController;
    private MenuControls menuControlsMock;

    @BeforeEach
    public void setUp() {
        menuControlsMock = mock(MenuControls.class);
        menuControlsController = new MenuControlsController(menuControlsMock);
    }

    @Test
    public void testStep_SelectBackToMenuAction() throws IOException {
        // Testa se a seleção de voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuControlsMock.isSelectedBackToMenu()).thenReturn(true);

        menuControlsController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_QuitBackToMenuAction() throws IOException {
        // Testa se a ação de sair e voltar ao menu leva ao estado de menu do jogo
        Game gameMock = mock(Game.class);
        when(menuControlsMock.isSelectedBackToMenuA()).thenReturn(true);

        menuControlsController.step(gameMock, GUI.ACTION.QUIT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }
}
