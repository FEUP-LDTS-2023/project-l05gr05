package com.aor.pacxon;

import com.aor.pacxon.gui.LanternaGUI;
import com.aor.pacxon.model.Menu;
import com.aor.pacxon.states.MenuState;
import com.aor.pacxon.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }
}

