package com.pacxon.model;

public class Coin extends ObjectType{
    public Coin(int x, int y) {
        super(x, y);
    }

    public Coin(Position position) {
        super(position.getX(), position.getY());
    }
}
