package com.aor.pacxon.controllertest;

import com.aor.pacxon.controller.MenuController;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.Game;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.model.LoaderArenaBuilder;
import com.aor.pacxon.states.ControlsState;
import com.aor.pacxon.states.GameState;
import com.aor.pacxon.states.HTPState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class MenuControllerTest {
    private MenuController menuController;
    private Menu menuMock;

    @BeforeEach
    public void setUp() {
        menuMock = mock(Menu.class);
        menuController = new MenuController(menuMock);
    }

    @Test
    public void testStep_SelectExitAction() throws IOException {
        // Testa se a seleção de saída no menu leva ao estado nulo do jogo
        Game gameMock = mock(Game.class);
        when(menuMock.isSelectedExit()).thenReturn(true);

        menuController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(null);
    }

    @Test
    public void testStep_SelectControlsAction() throws IOException {
        // Testa se a seleção dos controles no menu leva ao estado de controles do jogo
        Game gameMock = mock(Game.class);
        when(menuMock.isSelectedControls()).thenReturn(true);

        menuController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(ControlsState.class));
    }

    @Test
    public void testStep_SelectHTPAction() throws IOException {
        // Testa se a seleção da secção "How to Play" no menu leva ao estado de "How to Play" do jogo
        Game gameMock = mock(Game.class);
        when(menuMock.isSelectedHTP()).thenReturn(true);

        menuController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(HTPState.class));
    }

    @Test
    public void testStep_SelectStartAction() throws IOException {
        // Testa se a seleção do início no menu inicia o jogo com um novo nível
        Game gameMock = mock(Game.class);
        when(menuMock.isSelectedStart()).thenReturn(true);
        LoaderArenaBuilder loaderArenaBuilderMock = mock(LoaderArenaBuilder.class);
        when(loaderArenaBuilderMock.createArena()).thenReturn(null);

        menuController.step(gameMock, GUI.ACTION.SELECT, 100L);
        verify(gameMock).setState(any(GameState.class));
    }

    // Teste adicional para um comportamento não previsto
    @Test
    public void testStep_UnrecognizedAction() throws IOException {
        // Testa se uma ação não reconhecida no menu não altera o estado do jogo
        Game gameMock = mock(Game.class);

        menuController.step(gameMock, GUI.ACTION.NONE, 100L);
        verify(gameMock, never()).setState(any()); // Verifica se o estado do jogo não é alterado
    }
}
