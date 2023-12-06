package com.aor.pacxon.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    /* Testa o método isEmpty, para determinar se este identifica corretamente
    se uma certa posição está ou não preenchida */
    @Test
    void testIsEmpty() {
        Arena arena = new Arena(5, 5);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(2, 2, false));
        arena.setWalls(walls);

        assertTrue(arena.isEmpty(new Position(1, 1))); // Posição vazia
        assertFalse(arena.isEmpty(new Position(2, 2))); // Posição com wall
    }


    /* Testa o método isMonster, para determinar se este identifica corretamente
    se uma certa posição contém ou não um Monster */
    @Test
    void testIsMonster() {
        Arena arena = new Arena(5, 5);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(3, 3)); // Assuming Monster(int, int) constructor
        arena.setMonsters(monsters);

        assertTrue(arena.isMonster(new Position(3, 3))); // Position with a monster
        assertFalse(arena.isMonster(new Position(2, 2))); // Empty position
    }


    /* Testa getters e setters para Pacman, monster list e wall list presentes na classe Arena */
    @Test
    void testGettersAndSetters() {
        Arena arena = new Arena(5, 5);

        Pacman pacman = new Pacman(1, 1);
        arena.setPacman(pacman);
        assertEquals(pacman, arena.getPacman());

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(3, 3));
        arena.setMonsters(monsters);
        assertEquals(monsters, arena.getMonsters());

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(2, 2, false));
        arena.setWalls(walls);
        assertEquals(walls, arena.getWalls());
    }


    /* Testa se os métodos getWidth e getHeight retornam a width e height corretamente */
    @Test
    void testGetWidthAndHeight() {
        Arena arena = new Arena(5, 8);
        assertEquals(5, arena.getWidth());
        assertEquals(8, arena.getHeight());
    }
}
