package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.Monster;
import com.pacxon.model.ObjectType;
import com.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ViewerTest {
    @Mock
    private GUI mockGui;

    private TestViewer testViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Monster testMonster = new Monster(5, 5);
        testViewer = new TestViewer(testMonster);
    }

    @Test
    void testDraw() throws IOException {
        testViewer.draw(mockGui);

        verify(mockGui).clear();
        verify(mockGui).refresh();
    }

    static class TestViewer extends Viewer<Monster> {
        public TestViewer(Monster model) {
            super(model);
        }

        @Override
        protected void drawElements(GUI gui) {
            // Desenha o monstro na GUI
            Position position = getModel().getPosition();
            gui.drawMonster(position);
        }
    }
}
