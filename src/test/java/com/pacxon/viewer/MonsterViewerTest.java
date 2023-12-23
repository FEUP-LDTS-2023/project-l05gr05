package com.pacxon.viewer;


import com.pacxon.gui.GUI;
import com.pacxon.model.Monster;
import com.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class MonsterViewerTest {

    private MonsterViewer viewer;

    @Mock
    private Monster mockMonster;

    @Mock
    private GUI mockGui;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        viewer = new MonsterViewer();
    }

    @Test
    void testDraw() {
        Position monsterPosition = new Position(5, 5);
        when(mockMonster.getPosition()).thenReturn(monsterPosition);

        viewer.draw(mockMonster, mockGui);

        verify(mockGui, times(1)).drawMonster(monsterPosition);
    }
}
