package com.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {

    //testa se o objeto Monster é inicializado com a posição correta
    @Test
    void testInitialization() {
        Monster monster = new Monster(2, 3);
        assertEquals(new Position(2, 3), monster.getPosition());
    }


    //testa se a posição de monster pode ser alterada
    @Test
    void testPositionChange() {
        Monster monster = new Monster(2, 3);
        monster.setPosition(new Position(4, 5));
        assertEquals(new Position(4, 5), monster.getPosition());
    }

    //por implementar: testar interação entre monsters e pacman
    @Test
    void testMonsterInteractions() {
    }

}
