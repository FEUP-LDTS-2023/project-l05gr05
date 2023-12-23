package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.model.Arena;
import com.pacxon.model.Monster;
import com.pacxon.model.Pacman;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;
import com.pacxon.gui.GUI;
import com.pacxon.model.MenuWinLevel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import com.pacxon.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.*;
public class MonsterControllerTest {
    @Mock
    private Arena mockArena;

    @Mock
    private Monster mockMonster;

    @Mock
    private Pacman mockPacman;

    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockArena.getMonsters()).thenReturn(Collections.singletonList(mockMonster));
        when(mockArena.getPacman()).thenReturn(mockPacman);
        when(mockArena.isEmpty(any(Position.class))).thenReturn(true);
        monsterController = new MonsterController(mockArena);
    }

    @Test
    void testMonsterMovementTiming() throws IOException {
        long initialTime = 1000;  // Tempo inicial
        monsterController.step(mock(Game.class), GUI.ACTION.NONE, initialTime);
        verify(mockMonster, never()).setPosition(any(Position.class));

        long timeAfterDelay = initialTime + 501; // Tempo após o intervalo
        monsterController.step(mock(Game.class), GUI.ACTION.NONE, timeAfterDelay);
        verify(mockMonster, times(1)).setPosition(any(Position.class));
    }

    @Test
    void testMonsterCollisionWithPacman() throws IOException {
        Position pacmanPosition = new Position(1, 1);
        when(mockMonster.getPosition()).thenReturn(pacmanPosition);
        when(mockPacman.getPosition()).thenReturn(pacmanPosition);

        monsterController.step(mock(Game.class), GUI.ACTION.NONE, 1000);

        verify(mockPacman, times(1)).decreaseLives();
    }

    @Test
    void testMonsterAvoidsNonEmptyPositions() throws IOException {
        when(mockArena.isEmpty(any(Position.class))).thenReturn(false);

        monsterController.step(mock(Game.class), GUI.ACTION.NONE, 1000);

        verify(mockMonster, never()).setPosition(any(Position.class));
    }

}

