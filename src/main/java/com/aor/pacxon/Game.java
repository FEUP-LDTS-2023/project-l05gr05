package com.aor.pacxon;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.TerminalScreen;


import java.io.IOException;

public class Game {
    private Screen screen;
    private boolean running = true; // Adiciona uma flag para controlar o loop

    public void start() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.startScreen();
            screen.setCursorPosition(null); // Esconde o cursor
            screen.doResizeIfNecessary(); // Redimensiona se necessário

            while (running) { // Usa a flag como condição
                screen.clear();
                // Desenhar elementos do jogo
                screen.refresh();

                // Verifica condições de saída, como input do usuário, etc.
                // Exemplo: se (input == sair) running = false;

                Thread.sleep(20); // Pausa para não rodar muito rápido
            }

            screen.stopScreen();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Método para parar o jogo
    public void stop() {
        running = false;
    }
}