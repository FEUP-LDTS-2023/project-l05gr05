package com.pacxon.viewer;

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

import static org.mockito.Mockito.*;

import com.pacxon.model.*;

public class GameViewerTest {

    @Mock
    private GUI mockGui;

    @Mock
    private Arena mockArena;

    private GameViewer gameViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameViewer = new GameViewer(mockArena);
    }

    @Test
    void testDrawElements() {
        Wall wall = new Wall(new Position(1, 1));
        Monster monster = new Monster(new Position(2, 2));
        Pacman pacman = new Pacman(new Position(3, 3));
        Coin coin = new Coin(new Position(4, 4));
        when(mockArena.getWalls()).thenReturn(Arrays.asList(wall));
        when(mockArena.getMonsters()).thenReturn(Arrays.asList(monster));
        when(mockArena.getPacman()).thenReturn(pacman);
        when(mockArena.getCoins()).thenReturn(Arrays.asList(coin));
        gameViewer.drawElements(mockGui);
        verify(mockGui).drawWall(wall.getPosition());
        verify(mockGui).drawMonster(monster.getPosition());
        verify(mockGui).drawPacman(pacman.getPosition());
        verify(mockGui).drawCoin(coin.getPosition());
    }

    @Test
    void testDrawText() {
        Pacman pacman = new Pacman(new Position(3, 3));
        when(mockArena.getPacman()).thenReturn(pacman);
        when(mockArena.getLevel()).thenReturn(1);
        gameViewer.drawElements(mockGui);
        verify(mockGui).drawText(new Position(0, 0), "Lives: " + pacman.getLives(), "#FFD700");
        verify(mockGui).drawText(new Position(25, 0), "Level: 1", "#FFD700");
        verify(mockGui).drawText(new Position(53, 0), "Points: 100", "#FFD700");
    }
}