package com.pacxon.controller;

import com.pacxon.Game;
import com.pacxon.gui.GUI;
import com.pacxon.model.Arena;
import com.pacxon.model.Pacman;
import com.pacxon.model.Position;
import com.pacxon.states.DieState;
import com.pacxon.states.State;
import com.pacxon.states.WinGameState;
import com.pacxon.states.WinLevelState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ArenaControllerTest {
    @Mock
    private Arena mockArena;

    @Mock
    private Game mockGame;

    @Mock
    private Pacman mockPacman;

    private ArenaController arenaController;

    @Spy
    private PacmanController pacmanController;

    @Spy
    private MonsterController monsterController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockArena.getPacman()).thenReturn(mockPacman);
        pacmanController = spy(new PacmanController(mockArena));
        monsterController = spy(new MonsterController(mockArena));
        arenaController = new ArenaController(mockArena);
    }

    @Test
    void testGameStateChangeOnQuitAction() throws IOException {
        arenaController.step(mockGame, GUI.ACTION.QUIT, 0);
        verify(mockGame).setState(any(DieState.class));
    }

    @Test
    void testGameStateChangeWhenPacmanDies() throws IOException {
        Pacman mockPacman = mock(Pacman.class);
        when(mockArena.getPacman()).thenReturn(mockPacman);
        when(mockPacman.getLives()).thenReturn((float) 0);

        arenaController.step(mockGame, GUI.ACTION.NONE, 0);
        verify(mockGame).setState(any(DieState.class));
    }

    @Test
    void testPacmanAndMonsterControllerInteraction() throws IOException {
        arenaController.step(mockGame, GUI.ACTION.NONE, 0);

        // Verificar se o método step do PacmanController foi chamado
        verify(pacmanController).step(mockGame, GUI.ACTION.NONE, 0);

        // Verificar se o método step do MonsterController foi chamado
        verify(monsterController).step(mockGame, GUI.ACTION.NONE, 0);
    }

    @Test
    void testCoinCollectionAndScoring() throws IOException {
        // Configuração inicial
        int initialScore = 100;
        Position pacmanPosition = new Position(5, 5);
        when(mockPacman.getPosition()).thenReturn(pacmanPosition);
        when(mockPacman.getPoints()).thenReturn(initialScore);
        when(mockArena.hitCoin()).thenReturn(true);

        // Chama o método step
        arenaController.step(mockGame, GUI.ACTION.NONE, 0);

        // Verifica se os pontos foram adicionados ao Pacman
        verify(mockPacman).addPointsByCoin();

        // Verifica se a moeda foi removida da posição do Pacman
        verify(mockArena).removeCoin(pacmanPosition);
    }

    @Test
    void testLevelProgression() throws IOException {
        // Configuração para simular que o jogador preencheu 80% da arena
        when(mockArena.calculateFillPercentage()).thenReturn(80.0F);

        // Caso 1: Simula que o jogador está no nível 1
        when(mockArena.getLevel()).thenReturn(1);
        arenaController.step(mockGame, GUI.ACTION.NONE, 0);
        verify(mockGame).setState(any(WinLevelState.class));

        // Caso 2: Simula que o jogador está no último nível e vence o jogo
        when(mockArena.getLevel()).thenReturn(2);
        arenaController.step(mockGame, GUI.ACTION.NONE, 0);
        verify(mockGame).setState(any(WinGameState.class));
    }

    @Test
    void testPacmanDiesAndGameStateChangesToDieState() throws IOException {
        // Configurar o Pacman para ter 0 vidas
        when(mockPacman.getLives()).thenReturn(0F);

        // Chamar o método step para simular um ciclo de jogo
        arenaController.step(mockGame, GUI.ACTION.NONE, 0);

        // Verificar se o estado do jogo muda para DieState
        ArgumentCaptor<State> stateCaptor = ArgumentCaptor.forClass(State.class);
        verify(mockGame).setState(stateCaptor.capture());
        assertTrue(stateCaptor.getValue() instanceof DieState);
    }

}
