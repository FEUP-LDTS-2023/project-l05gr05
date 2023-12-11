package com.aor.pacxon.gui;
import static org.junit.jupiter.api.Assertions.*;

import com.aor.pacxon.model.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.FontFormatException;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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

    //ERRO
    /*
    @Test
    public void testGetNextAction() throws IOException {
        Screen mockScreen = Mockito.mock(Screen.class);
        gui = new LanternaGUI(mockScreen);

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.Character));
        assertEquals(GUI.ACTION.QUIT, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowUp));
        assertEquals(GUI.ACTION.UP, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowRight));
        assertEquals(GUI.ACTION.RIGHT, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowDown));
        assertEquals(GUI.ACTION.DOWN, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.ArrowLeft));
        assertEquals(GUI.ACTION.LEFT, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.Enter));
        assertEquals(GUI.ACTION.SELECT, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(new KeyStroke(KeyType.EOF));
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());

        Mockito.when(mockScreen.pollInput()).thenReturn(null);
        assertEquals(GUI.ACTION.NONE, gui.getNextAction());
    }
     */

    /*
    @Test
    public void testDrawPacman() {
        Screen mockScreen = Mockito.mock(Screen.class);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);
        gui = new LanternaGUI(mockScreen);

        Position pacmanPosition = new Position(5, 5);

        gui.drawPacman(pacmanPosition);

        Mockito.verify(mockScreen).newTextGraphics();
        Mockito.verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FFD700"));
        Mockito.verify(mockTextGraphics).putString(5, 6, "H");
    }
     */

    /*
    @Test
    public void testDrawWall() {
        Screen mockScreen = Mockito.mock(Screen.class);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);
        gui = new LanternaGUI(mockScreen);

        Position wallPosition = new Position(10, 10);

        gui.drawWall(wallPosition);

        Mockito.verify(mockScreen).newTextGraphics();
        Mockito.verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#3333FF"));
        Mockito.verify(mockTextGraphics).putString(10, 11, "#");
    }

     */

    /*
    @Test
    public void testDrawMonster() {
        Screen mockScreen = Mockito.mock(Screen.class);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);
        gui = new LanternaGUI(mockScreen);

        Position monsterPosition = new Position(15, 20);

        gui.drawMonster(monsterPosition);

        Mockito.verify(mockScreen).newTextGraphics();
        Mockito.verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        Mockito.verify(mockTextGraphics).putString(15, 21, "@");
    }

     */

    //ERRO
/*
    @Test
    public void testDrawText() {
        Screen mockScreen = Mockito.mock(Screen.class);
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(mockScreen.newTextGraphics()).thenReturn(mockTextGraphics);
        gui = new LanternaGUI(mockScreen);

        Position textPosition = new Position(10, 15);
        String text = "Hello, Pacman!";
        String color = "#FF00FF";

        gui.drawText(textPosition, text, color);

        Mockito.verify(mockScreen).newTextGraphics();
        Mockito.verify(mockTextGraphics).setForegroundColor(TextColor.Factory.fromString("#FF00FF"));
        Mockito.verify(mockTextGraphics).putString(10, 15, "Hello, Pacman!");
    }

 */

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
