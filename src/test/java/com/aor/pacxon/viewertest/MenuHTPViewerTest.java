package com.aor.pacxon.viewertest;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.MenuHTP;
import com.aor.pacxon.model.Position;
import com.aor.pacxon.viewer.MenuHTPViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MenuHTPViewerTest {
    private MenuHTPViewer menuHTPViewer;
    private GUI gui;
    private MenuHTP menuHTP;

    @BeforeEach
    public void setUp() {
        menuHTP = mock(MenuHTP.class);
        menuHTPViewer = new MenuHTPViewer(menuHTP);
        gui = mock(GUI.class);
    }

    @Test
    // Testa se o método drawElements desenha corretamente o texto "RETURN TO MAIN MENU" na posição (5, 5) com a cor #FFA500
    public void testDrawElements_ReturnToMainMenu() {
        menuHTPViewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 5), "RETURN TO MAIN MENU", "#FFA500");
    }

    @Test
    // Testa se o método drawElements desenha corretamente a introdução do jogo nas posições e cores adequadas
    public void testDrawElements_IntroductionText() {
        menuHTPViewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 7), "In this game you play as a pacman who tries to conquer the map", "#FFFFFF");
        verify(gui).drawText(new Position(5, 8), "while the monsters try to stop you by chasing you! RUUUNNNN!!!", "#FFFFFF");
        verify(gui).drawText(new Position(5, 9), "The main  goal is to be the owner of  80% of the map in  order", "#FFFFFF");
        verify(gui).drawText(new Position(5, 10), "to progress to a new level all the while trying to avoid being", "#FFFFFF");
        verify(gui).drawText(new Position(5, 11), "hit by the monsters.", "#FFFFFF");
    }

    @Test
    // Testa se o método drawElements desenha corretamente a mensagem de boa sorte e diversão na posição (5, 13)
    public void testDrawElements_GoodLuckMessage() {
        menuHTPViewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 13), "Good luck and have fun!", "#FFFFFF");
    }
}
