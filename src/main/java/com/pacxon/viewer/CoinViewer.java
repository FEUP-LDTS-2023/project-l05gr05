package com.pacxon.viewer;

import com.pacxon.gui.GUI;
import com.pacxon.model.Coin;

public class CoinViewer implements ObjectViewer<Coin>{
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
