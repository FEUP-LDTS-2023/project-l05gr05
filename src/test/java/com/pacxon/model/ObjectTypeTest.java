package com.pacxon.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ObjectTypeTest {
    //verifica se o objeto é inicializado com a posição correta
    @Test
    void testInitialization() {
        ObjectType objectType = new ObjectType(2, 3);
        assertEquals(new Position(2, 3), objectType.getPosition());
    }

    //testa se a posição é alterada
    @Test
    void testPositionChange() {
        ObjectType objectType = new ObjectType(2, 3);
        objectType.setPosition(new Position(4, 5));
        assertEquals(new Position(4, 5), objectType.getPosition());
    }


}
