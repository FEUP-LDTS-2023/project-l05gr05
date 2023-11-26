package com.aor.pacxon;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
/**    private Game game;
    private Screen screen;

    @BeforeEach
    public void setUp() {
        // inicializa um novo objeto Game antes de cada teste
        game = new Game();
    }

    @AfterEach
    public void tearDown() {
        // apaga depois de cada teste
        if (screen != null) {
            try {
                screen.stopScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        game.stop();
    }

    @Test
    public void testGameInitialization() {
        // testa se o objeto Game é inicializado corretamente
        assertNotNull(game);
    }
*/
    /*
    @Test
     public void testStartAndStopMethods() {
        // testa se os métodos start() e stop() executam corretamente
        game.start();
        assertTrue(game.isRunning());  // isRunning por implementar
        game.stop();
        assertFalse(game.isRunning());
    }
     */

    /*
    @Test
    public void testScreenInitialization() {
        // testa a inicialização do ecrã
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            game.setScreen(screen); // setScreen por implementar
            game.start();
            assertNotNull(screen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */
    /*
    @Test
    public void testGameLoop() {
        // testa o loop do jogo
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            game.setScreen(screen); // setScreen por implementar
            game.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */
}