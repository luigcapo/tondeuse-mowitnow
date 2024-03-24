package com.mowitnow.command;

import com.mowitnow.model.Tondeuse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AvancerCommandTest {
    @Mock
    Tondeuse mockTondeuse; // Crée un mock de Tondeuse

    @InjectMocks
    AvancerCommand command;
    @Test
    void executeShouldCallAvancerOnTondeuse() {
        command.execute();
        verify(mockTondeuse).avancer();
    }

}
