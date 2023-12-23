package com.pacxon;


import com.pacxon.gui.LanternaGUI;
import com.pacxon.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import com.pacxon.gui.GUI;
import com.pacxon.model.Arena;
import com.pacxon.model.Pacman;
import com.pacxon.model.Position;
import com.pacxon.model.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
public class GameTest {
    @Mock
    private LanternaGUI mockGui;

    @Mock
    private State mockState;

    @Mock
    private MusicSound mockMusic;

    private Game game;

    @BeforeEach
    void setUp() throws IOException, FontFormatException, URISyntaxException {
        MockitoAnnotations.openMocks(this);
        game = new Game();
    }

    @Test
    void testSetState() {
        State newState = mock(State.class);
        game.setState(newState);
        assertEquals(newState, game.getState());
    }

    @Test
    void testGameStart() throws IOException {
        game.start();
        assertTrue(game.isRunning());
        verify(mockMusic).play();
    }

    @Test
    void testGameStateStepExecution() throws IOException {
        game.start();
        verify(mockState, atLeastOnce()).step(any(Game.class), any(GUI.class), anyLong());
    }

    @Test
    void testGameEnd() throws IOException {
        game.setState(null); // Encerra o jogo
        verify(mockGui).close();
        verify(mockMusic).stop();
    }


    @Test
    void testStateChangeDuringGame() throws IOException {
        State newState = mock(State.class);
        game.start();
        game.setState(newState);
        verify(newState, atLeastOnce()).step(any(Game.class), any(GUI.class), anyLong());
    }


    @Test
    void testGamePause() throws IOException {
        game.start();
        game.pause();
        assertFalse(game.isRunning());
    }

    @Test
    void testExceptionHandling() throws IOException {
        doThrow(IOException.class).when(mockGui).refresh();
        assertDoesNotThrow(() -> game.start());
    }

    @Test
    void testGameLoopEnds() throws IOException {
        game.setState(null);
        game.start();
        assertFalse(game.isRunning());
    }
}