package com.pacxon.gui;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;

import com.googlecode.lanterna.screen.Screen;

public class LanternaGUITest {

    private LanternaGUI gui;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        // inicializa GUI para os testes
        gui = new LanternaGUI(80, 40);
    }

    @Test
    public void testInitialization() {
        assertNotNull(gui);
    }


    @Test
    public void testClear() {
        Screen mockScreen = Mockito.mock(Screen.class);
        gui = new LanternaGUI(mockScreen);

        gui.clear();

        Mockito.verify(mockScreen).clear();
    }


    @Test
    public void testRefresh() throws IOException {
        Screen mockScreen = Mockito.mock(Screen.class);
        gui = new LanternaGUI(mockScreen);

        gui.refresh();

        Mockito.verify(mockScreen).refresh();
    }

    @Test
    public void testClose() throws IOException {
        Screen mockScreen = Mockito.mock(Screen.class);
        gui = new LanternaGUI(mockScreen);

        gui.close();

        Mockito.verify(mockScreen).close();
    }
}
