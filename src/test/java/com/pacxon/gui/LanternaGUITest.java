package com.pacxon.gui;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.pacxon.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;
import java.util.Collection;

import com.googlecode.lanterna.screen.Screen;

public class LanternaGUITest {

    private LanternaGUI gui;

    private Screen mockScreen;

    private TextGraphics mockTextGraphics;

    @BeforeEach
    public void setUp() throws IOException, URISyntaxException, FontFormatException {
        // inicializa GUI para os testes
        mockScreen = Mockito.mock(Screen.class);
        mockTextGraphics = Mockito.mock(TextGraphics.class);
        when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);

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


    @Test
    public void testGetNextActionCharacterKey() throws IOException {
        KeyStroke mockedKeyStroke = new KeyStroke('a', false, false);
        Screen mockScreen = Mockito.mock(Screen.class);
        when(mockScreen.pollInput()).thenReturn(mockedKeyStroke);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.NONE, result); 
    }

    // Testar comportamento quando pollInput retorna null
    @Test
    public void testGetNextActionNullInput() throws IOException {
        Screen mockScreen = Mockito.mock(Screen.class);
        when(mockScreen.pollInput()).thenReturn(null);

        gui = new LanternaGUI(mockScreen);

        GUI.ACTION result = gui.getNextAction();

        assertEquals(GUI.ACTION.NONE, result);
    }

    // Testar a resposta a uma exceção
    @Test
    public void testGetNextActionWithIOException() throws IOException {
        Screen mockScreen = Mockito.mock(Screen.class);
        when(mockScreen.pollInput()).thenThrow(new IOException());

        gui = new LanternaGUI(mockScreen);

        assertThrows(IOException.class, () -> gui.getNextAction());
    }


    @Test
    public void testDrawPacman() {
        Position position = new Position(1, 1);
        gui.drawPacman(position);
        Mockito.verify(mockTextGraphics).putString(1, 2, "C", (Collection<SGR>) TextColor.Factory.fromString("#FFD700"));
    }

    @Test
    public void testDrawWall() {
        Position position = new Position(2, 2);
        gui.drawWall(position);
        Mockito.verify(mockTextGraphics).putString(2, 3, "\u25A0", (Collection<SGR>) TextColor.Factory.fromString("#3333FF"));
    }

    @Test
    public void testDrawMonster() {
        Position position = new Position(3, 3);
        gui.drawMonster(position);
        Mockito.verify(mockTextGraphics).putString(3, 4, "M", (Collection<SGR>) TextColor.Factory.fromString("#CC0000"));
    }

    @Test
    public void testDrawText() {
        Position position = new Position(4, 4);
        String text = "Test";
        String color = "#FFFFFF";
        gui.drawText(position, text, color);
        Mockito.verify(mockTextGraphics).putString(4, 4, text, (Collection<SGR>) TextColor.Factory.fromString(color));
    }

    @Test
    public void testDrawCoin() {
        Position position = new Position(5, 5);
        gui.drawCoin(position);
        Mockito.verify(mockTextGraphics).putString(5, 6, "*", (Collection<SGR>) TextColor.Factory.fromString("#FFD700"));
    }

}
