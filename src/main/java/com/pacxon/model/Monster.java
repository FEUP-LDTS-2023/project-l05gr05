package com.pacxon.model;

public class Monster extends ObjectType {
    public Monster(int x, int y) {
        super(x, y);
    }
    @Override
    public void setPosition(Position position) {super.setPosition(position);}

}
