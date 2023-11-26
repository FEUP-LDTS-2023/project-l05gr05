package com.aor.pacxon.controllertest;

import com.aor.pacxon.controller.MonsterController;
import com.aor.pacxon.Game;
import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Arena;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class MonsterControllerTest {
    private MonsterController monsterController;
    private Arena arenaMock;
    private Pacman pacmanMock;
    private Monster monsterMock;

    @BeforeEach
    public void setUp() {
        arenaMock = mock(Arena.class);
        monsterController = new MonsterController(arenaMock);
        pacmanMock = mock(Pacman.class);
        monsterMock = mock(Monster.class);
    }
    /**
    @Test
    public void testStep_MoveMonsters() throws IOException {
        // Verifica se, ao chamar o método step(), os monstros se movem dentro da arena.
        // Confirma se o método setPosition é chamado para cada monstro.
        // Simula uma lista de monstros na arena
        List<Monster> monsters = new ArrayList<>();
        monsters.add(monsterMock);
        when(arenaMock.getMonsters()).thenReturn(monsters);

        // Simula um movimento para uma posição aleatória para cada monstro
        Position positionMock = mock(Position.class);
        when(monsterMock.getPosition()).thenReturn(positionMock);
        when(positionMock.getRandomNeighbour()).thenReturn(positionMock);

        // Chama o método step()
        monsterController.step(null, GUI.ACTION.NONE, 100L);

        // Verifica se setPosition foi chamado para cada monstro
        verify(monsterMock, times(1)).setPosition(any(Position.class));
        verify(arenaMock, never()).getPacman();
    }
    */
}

