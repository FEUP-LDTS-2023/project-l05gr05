package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CoinViewerTest {

    private CoinViewer coinViewer;
    private GUI gui;

    @BeforeEach
    public void setUp() {
        gui = Mockito.mock(GUI.class);
        coinViewer = new CoinViewer();
    }

    @Test
    public void testDrawCoin() {
        Coin coin = new Coin(5, 5);

        coinViewer.draw(coin, gui);
        verify(gui, times(1)).drawCoin(coin.getPosition());
    }

    @Test
    public void testDrawCoinMultipleTimes() {
        Coin coin = new Coin(3, 3); // You may adjust the position as needed
        coinViewer.draw(coin, gui);
        coinViewer.draw(coin, gui);
        coinViewer.draw(coin, gui);
        verify(gui, times(3)).drawCoin(coin.getPosition());
    }

    @Test
    public void testDrawDifferentCoins() {
        Coin coin1 = new Coin(2, 2);
        Coin coin2 = new Coin(4, 4);
        coinViewer.draw(coin1, gui);
        coinViewer.draw(coin2, gui);
        verify(gui, times(1)).drawCoin(coin1.getPosition());
        verify(gui, times(1)).drawCoin(coin2.getPosition());
    }
}

