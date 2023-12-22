package com.aor.pacxon.controller;

import com.aor.pacxon.model.Arena;
import com.aor.pacxon.model.Pacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ArenaControllerTest {
    private ArenaController arenaController;
    private Arena arenaMock;
    private Pacman pacmanMock;

    @BeforeEach
    public void setUp() {
        arenaMock = mock(Arena.class);
        arenaController = new ArenaController(arenaMock);
        pacmanMock = mock(Pacman.class);
        when(arenaMock.getPacman()).thenReturn(pacmanMock);
    }

}
