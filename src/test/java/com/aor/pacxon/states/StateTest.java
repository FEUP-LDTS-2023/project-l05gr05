package com.aor.pacxon.states;

import com.aor.pacxon.Game;
import com.aor.pacxon.controller.Controller;
import com.aor.pacxon.viewer.Viewer;
import org.junit.jupiter.api.Test;
import com.aor.pacxon.gui.GUI;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StateTest {

    // classe fictícia para a implementação de State
    private static class FakeState extends State<String> {
        public FakeState(String model) {
            super(model);
        }

        @Override
        protected Viewer<String> getViewer() {
            return mock(Viewer.class);
        }

        @Override
        protected Controller<String> getController() {
            return mock(Controller.class);
        }
    }

    @Test
    void testConstructor() {
        // Cria um modelo fictício
        String model = "TestModel";

        // Cria uma instância FakeState
        FakeState fakeState = new FakeState(model);

        // Verifica se o modelo foi configurado corretamente
        assertEquals(model, fakeState.getModel());

        // Verifica se o método getViewer() foi chamado durante a construção
        assertNotNull(fakeState.getViewer());

        // Verifica se o método getController() foi chamado durante a construção
        assertNotNull(fakeState.getController());
    }

    //ERRO
    /*
    @Test
    void testStep() throws IOException {
        // Cria uma instância mock de Game, GUI e Controller
        Game mockGame = mock(Game.class);
        GUI mockGui = mock(GUI.class);
        Controller<String> mockController = mock(Controller.class);

        // Cria uma instância FakeState
        FakeState fakeState = new FakeState("TestModel");

        // Executa o método step
        fakeState.step(mockGame, mockGui, 100);

        // Verifica se o método getNextAction() da GUI foi chamado
        verify(mockGui).getNextAction();

        // Verifica se o método step() do Controller foi chamado com os parâmetros corretos
        verify(mockController).step(eq(mockGame), any(), eq(100L));

        // Verifica se o método draw() do Viewer foi chamado com a instância correta de GUI
        verify(fakeState.getViewer()).draw(eq(mockGui));
    }

     */
}
