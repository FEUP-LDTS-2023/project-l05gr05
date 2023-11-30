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

    @Test
    public void testMovePacmanLeft_EmptyPosition() {
        // Verifica se o Pacman se move para a esquerda quando a posição está vazia.
        Position positionMock = mock(Position.class);
        when(pacmanMock.getPosition()).thenReturn(positionMock);
        when(positionMock.getLeft()).thenReturn(positionMock);
        when(arenaMock.isEmpty(positionMock)).thenReturn(true);

        pacmanController.movePacmanLeft();

        verify(pacmanMock).setPosition(positionMock);
        verify(pacmanMock, never()).decreaseLives();
    }
    /**
    @Test
    public void testMovePacmanRight_WithMonster() {
        // Verifica se o Pacman tenta se mover para a direita e encontra um monstro.
        Position positionMock = mock(Position.class);
        when(pacmanMock.getPosition()).thenReturn(positionMock);
        when(positionMock.getRight()).thenReturn(positionMock);
        when(arenaMock.isEmpty(positionMock)).thenReturn(false);
        when(arenaMock.isMonster(positionMock)).thenReturn(true);

        pacmanController.movePacmanRight();

        verify(pacmanMock, never()).setPosition(positionMock);
        verify(pacmanMock).decreaseEnergy();
    }
    */
}
