package com.aor.pacxon.viewer;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.Pacman;
import com.aor.pacxon.model.Coin;
import com.aor.pacxon.model.Monster;

public class CoinViewer implements ObjectViewer<Coin>{
    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
