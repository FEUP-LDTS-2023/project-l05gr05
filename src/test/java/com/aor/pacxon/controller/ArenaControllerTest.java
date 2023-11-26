package com.aor.pacxon.controller;

import com.aor.pacxon.model.Arena;
import com.aor.pacxon.model.Pacman;
import org.junit.jupiter.api.BeforeEach;

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
/**
    @Test
    public void testStep_MenuStateOnQuitAction() throws IOException {
        // Verifica se o estado do jogo muda para o MenuState quando a ação é QUIT
        Game gameMock = mock(Game.class);
        when(pacmanMock.getEnergy()).thenReturn(null);

        arenaController.step(gameMock, GUI.ACTION.QUIT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_MenuStateOnPacmanEnergyZero() throws IOException {
        // Verifica se o estado do jogo muda para o MenuState quando a energia do Pacman é zero
        Game gameMock = mock(Game.class);
        when(pacmanMock.getEnergy()).thenReturn(null);

        arenaController.step(gameMock, GUI.ACTION.QUIT, 100L);
        verify(gameMock).setState(any(MenuState.class));
    }

    @Test
    public void testStep_ContinuesGameOnValidAction() throws IOException {
        // Verifica se o jogo continua normalmente para outras ações válidas
        Game gameMock = mock(Game.class);
        when(pacmanMock.getEnergy()).thenReturn(null);

        arenaController.step(gameMock, GUI.ACTION.NONE, 100L);
        verify(gameMock, never()).setState(any(MenuState.class));
    }
    */
}
