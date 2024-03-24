package com.mowitnow.command;

import com.mowitnow.model.Orientation;
import com.mowitnow.model.Tondeuse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PivoterGaucheCommandTest {

    @Mock
    Tondeuse mockTondeuse; // Crée un mock de Tondeuse

    @InjectMocks
    PivoterGaucheCommand command;

    @Test
    void executePermetDeTournerLaTondeuseGauche() {

        when(mockTondeuse.getOrientation()).thenReturn(Orientation.SOUTH);
        command.execute();
        verify(mockTondeuse).setOrientation(Orientation.EAST);
    }
}
