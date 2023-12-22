package com.pacxon.controller;

import com.pacxon.model.Arena;
import com.pacxon.model.Pacman;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class PacmanControllerTest {
    private PacmanController pacmanController;
    private Arena arenaMock;
    private Pacman pacmanMock;

    @BeforeEach
    public void setUp() {
        arenaMock = mock(Arena.class);
        pacmanController = new PacmanController(arenaMock);
        pacmanMock = mock(Pacman.class);
        when(arenaMock.getPacman()).thenReturn(pacmanMock);
    }

}
