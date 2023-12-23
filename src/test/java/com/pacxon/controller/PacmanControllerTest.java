package com.pacxon.controller;

import com.pacxon.gui.GUI;
import com.pacxon.model.Arena;
import com.pacxon.model.Pacman;
import com.pacxon.model.Position;
import com.pacxon.states.DieState;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;
import com.pacxon.Game;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;


public class PacmanControllerTest {
    @Mock
    private Arena mockArena;

    @Mock
    private Pacman mockPacman;

    @Mock
    private Game mockGame;

    private PacmanController pacmanController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockArena.getPacman()).thenReturn(mockPacman);
        pacmanController = new PacmanController(mockArena);
    }

    @Test
    void testMovePacman() {
        Position initialPosition = new Position(5, 5);
        when(mockPacman.getPosition()).thenReturn(initialPosition);
        when(mockArena.isEmpty(any(Position.class))).thenReturn(true);

        pacmanController.movePacmanLeft();
        verify(mockPacman).setPosition(new Position(4, 5));

        pacmanController.movePacmanRight();
        verify(mockPacman).setPosition(new Position(6, 5));

        pacmanController.movePacmanUp();
        verify(mockPacman).setPosition(new Position(5, 4));

        pacmanController.movePacmanDown();
        verify(mockPacman).setPosition(new Position(5, 6));
    }

    @Test
    void testPacmanDeathChangesGameState() {
        when(mockPacman.isDead()).thenReturn(true);

        pacmanController.step(mockGame, GUI.ACTION.NONE, 0);

        verify(mockGame).setState(any(DieState.class));
    }

}
