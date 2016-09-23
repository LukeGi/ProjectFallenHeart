package com.github.bluemonster122.energy;

public class GeneratorBattery extends Battery {
    public GeneratorBattery(int maxExtract, int capacity) {
        super(0, maxExtract, capacity);
    }

    public int generate(int amount, boolean simulate) {
        int maxReceive = capacity;
        int energyReceived = Math.min(capacity - energy, Math.min(maxReceive, amount));
        if (!simulate)
            energy += energyReceived;
        return energyReceived;
    }

    @Override
    protected String getEnergyNBTKey() {
        return "[energy]-NF";
    }
}
