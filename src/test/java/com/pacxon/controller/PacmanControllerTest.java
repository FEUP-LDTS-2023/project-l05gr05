package com.pacxon.controller;

import com.pacxon.model.Arena;
import com.pacxon.model.Pacman;
import com.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;
import com.pacxon.Game;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;


public class PacmanControllerTest {
    @Mock
    private Game game;
    @Mock
    private Arena arena;
    @Mock
    private Pacman pacman;

    private PacmanController pacmanController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(arena.getPacman()).thenReturn(pacman);
        when(pacman.getPosition()).thenReturn(new Position(5, 5));
        when(arena.getWidth()).thenReturn(10);
        when(arena.getHeight()).thenReturn(10);

        pacmanController = new PacmanController(arena);
    }

    @Test
    void testMovePacmanLeft() {
        Position leftPosition = new Position(4, 5);
        when(arena.isEmpty(leftPosition)).thenReturn(true);

        pacmanController.movePacmanLeft();

        verify(pacman).setPosition(leftPosition);
    }
}
