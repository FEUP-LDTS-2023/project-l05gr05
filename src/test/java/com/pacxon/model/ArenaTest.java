package com.pacxon.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
    }

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
        monsters.add(new Monster(3, 3));
        arena.setMonsters(monsters);

        assertTrue(arena.isMonster(new Position(3, 3)));
        assertFalse(arena.isMonster(new Position(2, 2)));
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

    @Test
    void testArenaInitialization() {
        assertEquals(10, arena.getWidth());
        assertEquals(10, arena.getHeight());
        assertNotNull(arena.getTrail());
        assertTrue(arena.getWalls().isEmpty());
    }

    @Test
    void testAddToTrailAndClearTrail() {
        Position position = new Position(5, 5);
        arena.addToTrail(position);

        assertFalse(arena.getTrail().isEmpty());
        assertTrue(arena.getWalls().stream().anyMatch(wall -> wall.getPosition().equals(position) && wall.isTemporary()));

        arena.clearTrail();
        assertTrue(arena.getTrail().isEmpty());
    }

    @Test
    void testCollisionDetection() {
        Position wallPosition = new Position(1, 1);
        arena.setWalls(List.of(new Wall(wallPosition.getX(), wallPosition.getY(), false)));

        assertFalse(arena.isEmpty(wallPosition));
    }

    @Test
    void testCoinCollection() {
        Position coinPosition = new Position(2, 2);
        Coin coin = new Coin(coinPosition.getX(), coinPosition.getY());
        arena.setCoin(List.of(coin));
        arena.setPacman(new Pacman(coinPosition.getX(), coinPosition.getY()));

        assertTrue(arena.hitCoin());
        arena.removeCoin(coinPosition);
        assertTrue(arena.getCoins().isEmpty());
    }

    @Test
    void testCalculateFillPercentage() {
        // Adiciona paredes para simular o preenchimento da arena
        List<Wall> walls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                walls.add(new Wall(i, j, false));
            }
        }
        arena.setWalls(walls);

        // Espera-se que 25% da arena esteja preenchida, pois 5x5 de um total de 10x10 está ocupado
        float expectedFillPercentage = 25.0f;
        float fillPercentage = arena.calculateFillPercentage();

        assertEquals(expectedFillPercentage, fillPercentage, 0.01);
    }

    @Test
    void testFillPolygon() {
        // Adiciona vértices para formar um quadrado
        List<Position> vertices = new ArrayList<>();
        vertices.add(new Position(2, 2));
        vertices.add(new Position(2, 5));
        vertices.add(new Position(5, 5));
        vertices.add(new Position(5, 2));

        arena.fillPolygon(vertices);

        // Verifica se as paredes foram adicionadas corretamente
        for (int x = 2; x <= 5; x++) {
            for (int y = 2; y <= 5; y++) {
                Position pos = new Position(x, y);
                assertFalse(arena.isEmpty(pos), "Posição esperada ser preenchida: " + pos);
            }
        }
    }
}
