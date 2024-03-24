package com.mowitnow.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrientationTest {

    @Test
    void getIdOrientation() {assertEquals("S", Orientation.SOUTH.getIdOrientation(), "getIdOrientation devrait retourner S pour SOUTH");
    }

    @Test
    void findOrientationFromIdValid() {
        assertEquals(Orientation.SOUTH, Orientation.findOrientationFromId("S"), "findOrientationFromId devrait retourner SOUTH pour 'S'");
    }

    @Test
    void findOrientationFromIdInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Orientation.findOrientationFromId("X");
        });
    }

    @Test
    void pivoterDroite() {
        assertEquals(Orientation.EAST, Orientation.NORTH.pivoterDroite(), "pivoterDroite de NORTH devrait retourner EAST");
        assertEquals(Orientation.WEST, Orientation.SOUTH.pivoterDroite(), "pivoterDroite de SOUTH devrait retourner WEST");
    }

    @Test
    void pivoterGauche() {
        assertEquals(Orientation.EAST, Orientation.SOUTH.pivoterGauche(), "pivoterGauche de SOUTH devrait retourner EAST");
        assertEquals(Orientation.WEST, Orientation.NORTH.pivoterGauche(), "pivoterGauche de NORTH devrait retourner WEST");
    }

}
