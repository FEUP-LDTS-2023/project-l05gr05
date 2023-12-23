package com.pacxon.model;

public class Monster extends ObjectType {
    public Monster(int x, int y) {
        super(x, y);
    }

    public Monster(Position position) {
        super(position.getX(), position.getY());
    }

    @Override
    public void setPosition(Position position) {super.setPosition(position);}

}
