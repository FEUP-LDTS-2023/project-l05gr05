package com.pacxon.states;

import com.pacxon.Game;
import com.pacxon.controller.ArenaController;
import com.pacxon.controller.Controller;
import com.pacxon.gui.GUI;
import com.pacxon.model.Arena;
import com.pacxon.viewer.GameViewer;
import com.pacxon.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameStateTest {
    private GameState gameState;
    private Arena mockArena;
    private GameViewer mockViewer;
    private ArenaController mockController;
    private Game mockGame;
    private GUI mockGui;

    @BeforeEach
    void setUp() {
        mockArena = Mockito.mock(Arena.class);
        mockViewer = Mockito.mock(GameViewer.class);
        mockController = Mockito.mock(ArenaController.class);
        mockGame = Mockito.mock(Game.class);
        mockGui = Mockito.mock(GUI.class);

        gameState = new GameState(mockArena) {
            @Override
            protected Viewer<Arena> getViewer() {
                return mockViewer;
            }

            @Override
            protected Controller<Arena> getController() {
                return mockController;
            }
        };
    }

    @Test
    void testGameStateInitialization() {
        assertEquals(mockArena, gameState.getModel());
    }

    @Test
    void testStep() throws IOException {
        when(mockGui.getNextAction()).thenReturn(GUI.ACTION.UP);

        gameState.step(mockGame, mockGui, 1000);

        verify(mockController).step(mockGame, GUI.ACTION.UP, 1000);
        verify(mockViewer).draw(mockGui);
    }
}


