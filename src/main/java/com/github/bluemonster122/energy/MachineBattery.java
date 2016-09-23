package com.github.bluemonster122.energy;

public class MachineBattery extends Battery {

    public MachineBattery(int maxIn, int maxStored) {
        super(maxIn, 0, maxStored);
    }

    @Override
    protected String getEnergyNBTKey() {
        return "[energy]-NF";
    }
}
