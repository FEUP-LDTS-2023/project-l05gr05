package com.pacxon.model;

public class Wall extends ObjectType {
    private boolean isTemporary;

    public Wall(int x, int y, boolean isTemporary) {
        super(x, y);
        this.isTemporary = isTemporary;
    }

    public Wall(Position position) {
        super(position.getX(), position.getY());
    }

    public boolean isTemporary() {
        return isTemporary;
    }

    public void makePermanent() {
        this.isTemporary = false;
    }
}
