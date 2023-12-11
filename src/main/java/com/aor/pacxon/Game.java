package com.aor.pacxon;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.gui.LanternaGUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.states.MenuState;
import com.aor.pacxon.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    private final MusicSound gameMusic;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(100, 40);
        this.state = new MenuState(new Menu());
        this.gameMusic = new MusicSound("musicfile path");
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        gameMusic.play();
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
        gameMusic.stop();
    }
}

