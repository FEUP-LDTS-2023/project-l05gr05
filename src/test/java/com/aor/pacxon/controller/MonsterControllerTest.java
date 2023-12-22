package com.aor.pacxon.controller;

import com.aor.pacxon.model.Arena;
import com.aor.pacxon.model.Monster;
import com.aor.pacxon.model.Pacman;
import org.junit.jupiter.api.BeforeEach;

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
}

