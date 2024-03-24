package com.mowitnow.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TondeuseTest {

    private Tondeuse tondeuse;
    private Pelouse pelouse;

    @BeforeEach
    void setUp() {
        pelouse = new Pelouse(5, 5); // Supposons que les dimensions de la pelouse soient 5x5
        tondeuse = new Tondeuse(pelouse);
    }

    @Test
    void testPositionTondeuse() {
        tondeuse.setX(2);
        tondeuse.setY(3);
        tondeuse.setOrientation(Orientation.NORTH);

        assertEquals(2, tondeuse.getX(), "La position X doit être 4");
        assertEquals(3, tondeuse.getY(), "La position Y  doit être 3");
        assertEquals(Orientation.NORTH, tondeuse.getOrientation(), "L'orientation doit être NORTH");
    }

    @Test
    void testPositionTondeuse_pourPositionHorsLimitePelouse() {
        assertThrows(IllegalArgumentException.class, ()->tondeuse.setX(10),
                "Doit lancer une IllegalArgumentException si y est hors limites");
    }

    @Test
    void testAvancerSouth() {
        tondeuse.setX(2);
        tondeuse.setY(2);
        tondeuse.setOrientation(Orientation.SOUTH);
        tondeuse.avancer();
        assertEquals(1, tondeuse.getY(), "Avancer vers le sud devrait décrémenter Y");
    }

    @Test
    void testAvancerWest() {
        tondeuse.setX(2);
        tondeuse.setY(2);
        tondeuse.setOrientation(Orientation.WEST);
        tondeuse.avancer();
        assertEquals(1, tondeuse.getX(), "Avancer vers l'ouest devrait décrémenter X");
    }

    @Test
    void testAvancerEast() {
        tondeuse.setX(2);
        tondeuse.setY(2);
        tondeuse.setOrientation(Orientation.EAST);
        tondeuse.avancer();
        assertEquals(3, tondeuse.getX(), "Avancer vers l'est devrait augmenter X");
    }

    @Test
    void testAvancerNorth() {
        tondeuse.setX(2);
        tondeuse.setY(2);
        tondeuse.setOrientation(Orientation.NORTH);
        tondeuse.avancer();
        assertEquals(3, tondeuse.getY(), "Avancer vers l'est devrait augmenter Y");
    }


    @Test
    void avancerNorth_avecpositionEnLimiteDePelouse() {
        tondeuse.setX(5);
        tondeuse.setY(2);
        tondeuse.setOrientation(Orientation.EAST);
        tondeuse.avancer();
        assertEquals(5, tondeuse.getX(), "Avancer en étant à la limite à l'est devrait laisser Y à sa position max");
    }

    @Test
    void avancerEast_avecpositionEnLimiteDePelouse() {
        tondeuse.setX(2);
        tondeuse.setY(5);
        tondeuse.setOrientation(Orientation.NORTH);
        tondeuse.avancer();
        assertEquals(5, tondeuse.getY(), "Avancer en étant à la limite au nord devrait laisser Y à sa position max");
    }

    @Test
    void avancerSouth_avecpositionEnLimiteDePelouse() {
        tondeuse.setX(2);
        tondeuse.setY(0);
        tondeuse.setOrientation(Orientation.SOUTH);
        tondeuse.avancer();
        assertEquals(0, tondeuse.getY(), "Avancer en étant à la limite à l'ouest devrait laisser Y à 0");
    }

    @Test
    void avancerWest_avecpositionEnLimiteDePelouse() {
        tondeuse.setX(0);
        tondeuse.setY(2);
        tondeuse.setOrientation(Orientation.WEST);
        tondeuse.avancer();
        assertEquals(0, tondeuse.getX(), "Avancer en étant à la limite à l'ouest devrait laisser X à 0");
    }

}
