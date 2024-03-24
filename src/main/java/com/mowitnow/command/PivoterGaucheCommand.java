package com.mowitnow.command;

import com.mowitnow.model.Tondeuse;

public class PivoterGaucheCommand implements Command{
    private Tondeuse tondeuse;

    public PivoterGaucheCommand(Tondeuse tondeuse) {
        this.tondeuse = tondeuse;
    }

    @Override
    public void execute() {
        tondeuse.setOrientation(tondeuse.getOrientation().pivoterGauche());
    }
}
