package com.aor.pacxon.controller;

import com.aor.pacxon.gui.GUI;
import com.aor.pacxon.model.*;
import com.aor.pacxon.states.MenuState;
import com.aor.pacxon.Game;
import com.aor.pacxon.states.WinGameState;
import com.aor.pacxon.states.WinLevelState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PacmanController pacmanController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        this.pacmanController = new PacmanController(arena);
        this.monsterController = new MonsterController(arena);
    }
}
/**    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
        if(getModel().getMonsters().size()==0 ){
            getModel().removeBarrel(91,5);
            pacmanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
        if(getModel().hitCoin()){
            getModel().getBomberman().addPointsByCoin();
            getModel().removeCoin(getModel().getBomberman().getPosition());
        }
        else if(getModel().getCoins().size()==0 && getModel().getLevel()==1){
            getModel().setLevel(getModel().getLevel() +1);
            game.setState(new WinLevelState(new MenuWinLevel(getModel().getBomberman().getPoints())));
        }
        else if(getModel().getCoins().size()==0 && getModel().getLevel()==2){
            getModel().setLevel(1);
            game.setState(new WinGameState(new MenuWinGame(getModel().getBomberman().getPoints())));
        }
        else {
            bombermanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}
*/