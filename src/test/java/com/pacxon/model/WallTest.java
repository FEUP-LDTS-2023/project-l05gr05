package com.pacxon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {

    //Testa se a wall é inicializada com a posição correta
    @Test
    void testInitialization() {
        Wall wall = new Wall(2, 3, false);
        assertEquals(new Position(2, 3), wall.getPosition());
    }

    //Testa se a posição da wall é alterada
    @Test
    void testPositionChange() {
        Wall wall = new Wall(2, 3, false);
        wall.setPosition(new Position(4, 5));
        assertEquals(new Position(4, 5), wall.getPosition());
    }

    //por implementar: testa interações entre as wall e outros objetos
    @Test
    void testWallInteractions() {
    }
}
