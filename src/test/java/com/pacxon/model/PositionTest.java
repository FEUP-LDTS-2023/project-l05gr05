package com.pacxon.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    //testa se o getter para x funciona orretamente
    @Test
    void testGetX() {
        Position position = new Position(3, 4);
        assertEquals(3, position.getX());
    }

    //testa se o getter para x funciona orretamente
    @Test
    void testGetY() {
        Position position = new Position(3, 4);
        assertEquals(4, position.getY());
    }

    //testa se a posição se move para a esquerda
    @Test
    void testGetLeft() {
        Position position = new Position(3, 4);
        Position left = position.getLeft();
        assertEquals(2, left.getX());
        assertEquals(4, left.getY());
    }

    //testa se a posição se move para a direita
    @Test
    void testGetRight() {
        Position position = new Position(3, 4);
        Position right = position.getRight();
        assertEquals(4, right.getX());
        assertEquals(4, right.getY());
    }

    //testa se a posição se move para cima
    @Test
    void testGetUp() {
        Position position = new Position(3, 4);
        Position up = position.getUp();
        assertEquals(3, up.getX());
        assertEquals(3, up.getY());
    }

    //testa se a posição se move para baixo
    @Test
    void testGetDown() {
        Position position = new Position(3, 4);
        Position down = position.getDown();
        assertEquals(3, down.getX());
        assertEquals(5, down.getY());
    }

    //verifica se o resultado é válido dentro dos valores de neighbors
    @Test
    void testGetRandomNeighbour() {
        Position position = new Position(3, 4);
        Position randomNeighbour = position.getRandomNeighbour();
        assertTrue(randomNeighbour.equals(position.getUp()) ||
                randomNeighbour.equals(position.getRight()) ||
                randomNeighbour.equals(position.getDown()) ||
                randomNeighbour.equals(position.getLeft()));
    }

    @Test
    void testEquals() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 4);
        Position position3 = new Position(2, 5);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    void testHashCode() {
        Position position1 = new Position(3, 4);
        Position position2 = new Position(3, 4);
        Position position3 = new Position(2, 5);

        assertEquals(position1.hashCode(), position2.hashCode());
        assertNotEquals(position1.hashCode(), position3.hashCode());
    }
}
