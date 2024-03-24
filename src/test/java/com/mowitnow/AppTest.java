package com.mowitnow;


import com.mowitnow.model.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.mowitnow.App.traiterFichier;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    void testAppWithResourceFile() throws Exception {
        System.setOut(new PrintStream(outContent));
        Path resourceDirectory = Paths.get("src","test","resources","kata.txt");
        String cheminFichier = resourceDirectory.toFile().getAbsolutePath();
        traiterFichier(cheminFichier);
        String expectedOutput = "1 3 N"; // Exemple de sortie attendue
        assertEquals(expectedOutput, outContent.toString().trim());
    }





}
