package com.github.bluemonster122.energy;

import net.minecraft.nbt.NBTTagCompound;

public abstract class Battery implements INaturalEnergy {

    protected int maxReceive;
    protected int maxExtract;
    protected int energy;
    protected int capacity;

    public Battery(int maxReceive, int maxExtract, int capacity) {
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.capacity = capacity;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        if (!canReceive())
            return 0;

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            energy += energyReceived;
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        if (!canExtract())
            return 0;

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            energy -= energyExtracted;
        return energyExtracted;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive() {
        return this.maxReceive > 0;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        nbt.setInteger(getEnergyNBTKey(), energy);
        return nbt;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        energy = nbt.getInteger(getEnergyNBTKey());
    }

    protected abstract String getEnergyNBTKey();
}
