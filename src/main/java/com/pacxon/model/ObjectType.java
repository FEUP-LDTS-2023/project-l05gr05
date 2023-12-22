package com.pacxon.model;

public class ObjectType {
    private Position position;

    public ObjectType(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }


}
