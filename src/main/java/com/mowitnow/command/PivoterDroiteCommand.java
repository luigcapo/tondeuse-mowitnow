package com.mowitnow.command;

import com.mowitnow.model.Orientation;
import com.mowitnow.model.Tondeuse;

public class PivoterDroiteCommand implements Command{

    private Tondeuse tondeuse;

    public PivoterDroiteCommand(Tondeuse tondeuse) {
        this.tondeuse = tondeuse;
    }

    @Override
    public void execute() {
        tondeuse.setOrientation(tondeuse.getOrientation().pivoterDroite());
    }
}
