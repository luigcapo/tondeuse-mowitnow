package com.mowitnow.command;

import com.mowitnow.model.Tondeuse;

public class AvancerCommand implements Command{

    private Tondeuse tondeuse;

    public AvancerCommand(Tondeuse tondeuse) {
        this.tondeuse = tondeuse;
    }

    @Override
    public void execute() {
        tondeuse.avancer();
    }
}
