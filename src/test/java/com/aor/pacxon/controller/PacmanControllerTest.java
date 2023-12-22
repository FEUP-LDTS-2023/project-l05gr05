package com.aor.pacxon.controller;

import com.aor.pacxon.model.Arena;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
