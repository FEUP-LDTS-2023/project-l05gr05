package com.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PacmanTest {

    /* Testa que criando um pacman com uma dada posição, p.e. (2,3), é inicializado com o valor correto
    de energia e de posição; garante se o construtor e os métodos getter para energia e posição funcionam como esperado */
    @Test
    void testInitialization() {
        Pacman pacman = new Pacman(2, 3);
        assertEquals(3, pacman.getLives());
        assertEquals(new Position(2, 3), pacman.getPosition());
    }

    @Test
    void testIsDead() {
        Pacman pacman = new Pacman(0, 0);
        assertFalse(pacman.isDead());

        pacman.setLives(0);
        assertTrue(pacman.isDead());
    }


    /* Testa se a energia é reduzida corretamente  */
    @Test
    void testDecreaseLives() {
        Pacman pacman = new Pacman(2, 3);
        pacman.decreaseLives();
        assertEquals(2, pacman.getLives());
    }


    //testa se a energia respeita o seu limite mínimo de 0 (não pode ser negativa)
    @Test
    void testLivesDoNotGoBelowZero() {
        Pacman pacman = new Pacman(2, 3);
        for (int i = 0; i < 12; i++) {
            pacman.decreaseLives();
        }
        assertEquals(0, pacman.getLives());
    }



    /* Testa se a posição é alterada  */
    @Test
    void testPositionChange() {
        Pacman pacman = new Pacman(2, 3);
        pacman.setPosition(new Position(4, 5));
        assertEquals(new Position(4, 5), pacman.getPosition());
    }

    @Test
    void testSetAndGetLives() {
        Pacman pacman = new Pacman(0, 0);
        pacman.setLives(5);

        assertEquals(5, pacman.getLives());
    }

    @Test
    void testAddPointsByCoin() {
        Pacman pacman = new Pacman(0, 0);
        pacman.addPointsByCoin();

        assertEquals(20, pacman.getPoints());
    }

    @Test
    void testSetAndGetPoints() {
        Pacman pacman = new Pacman(0, 0);
        pacman.setPoints(100);

        assertEquals(100, pacman.getPoints());
    }

}
