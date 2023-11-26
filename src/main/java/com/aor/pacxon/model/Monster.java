package com.aor.pacxon.model;

public class Monster extends ObjectType {
    private boolean isAlive;

    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void setPosition(Position position) {super.setPosition(position);}

    public void setAlive(boolean alive) {isAlive = alive;}

    public boolean getAlive() {return isAlive;}
}
