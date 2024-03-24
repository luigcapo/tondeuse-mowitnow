package com.mowitnow.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PelouseTest {
    Pelouse pelouse = new Pelouse(5, 7);

    @BeforeEach
    void initPelouse(){
        Pelouse pelouse = new Pelouse(5, 7);
    }

    @Test
    void testCreatePelouse() {
        assertNotNull(pelouse, "La pelouse devrait être créée");
    }

    @Test
    void testgetXmax() {
        assertEquals(5, pelouse.getXmax(), "getXmax devrait retourner 5");
    }

    @Test
    void testgetYmax() {
        assertEquals(7, pelouse.getYmax(), "getYmax devrait retourner 7");
    }

    @Test
    void testSetXmax() {
        pelouse.setXmax(10);
        assertEquals(10, pelouse.getXmax(), "setXmax devrait mettre à jour la valeur de xmax à 10");
    }

    @Test
    void testSetYmax() {
        pelouse.setYmax(12);
        assertEquals(12, pelouse.getYmax(), "setYmax devrait mettre à jour la valeur de ymax à 12");
    }
}
