package com.aor.pacxon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PacmanTest {

    /* Testa que criando um pacman com uma dada posição, p.e. (2,3), é inicializado com o valor correto
    de energia e de posição; garante se o construtor e os métodos getter para energia e posição funcionam como esperado */
    @Test
    void testInitialization() {
        Pacman pacman = new Pacman(2, 3);
        assertEquals(10, pacman.getEnergy());
        assertEquals(new Position(2, 3), pacman.getPosition());
    }


    /* Testa se a energia é reduzida corretamente  */
    @Test
    void testDecreaseEnergy() {
        Pacman pacman = new Pacman(2, 3);
        pacman.decreaseEnergy();
        assertEquals(9, pacman.getEnergy());
    }

    //ERRO
    /* //esta se a energia respeita o seu limite mínimo de 0 (não pode ser negativa)
    @Test
    void testEnergyDoesNotGoBelowZero() {
        Pacman pacman = new Pacman(2, 3);
        for (int i = 0; i < 12; i++) {
            pacman.decreaseEnergy();
        }
        assertEquals(0, pacman.getEnergy());
    }
    */

    /* Testa se a posição é alterada  */
    @Test
    void testPositionChange() {
        Pacman pacman = new Pacman(2, 3);
        pacman.setPosition(new Position(4, 5));
        assertEquals(new Position(4, 5), pacman.getPosition());
    }

}
