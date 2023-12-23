package com.pacxon.gui;
import static org.junit.jupiter.api.Assertions.*;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;
import static org.mockito.Mockito.when;

import com.googlecode.lanterna.screen.Screen;

public class LanternaGUITest {

    private LanternaGUI gui;
    private Screen screen;

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
    public void testGetNextActionArrowUp() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.ArrowUp);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.UP, result);
    }

    @Test
    public void testGetNextActionArrowDown() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.ArrowDown);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.DOWN, result);
    }

    @Test
    public void testGetNextActionArrowLeft() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.ArrowLeft);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.LEFT, result);
    }

    @Test
    public void testGetNextActionArrowRight() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.ArrowRight);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.RIGHT, result);
    }

    @Test
    public void testGetNextActionNone() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.Backspace);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.NONE, result);
    }

    @Test
    public void testGetNextActionEnterKey() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.Enter);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.SELECT, result);
    }

    @Test
    public void testGetNextActionQuitEOF() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke(KeyType.EOF);
        Screen mockScreen = Mockito.mock(Screen.class);
        Mockito.when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.QUIT, result);
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
