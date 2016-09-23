package com.github.bluemonster122.tileentity;

import com.github.bluemonster122.energy.GeneratorBattery;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPollenGenerator extends TileEntity {
    public GeneratorBattery battery = new GeneratorBattery(25, 5000);

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return battery.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        battery.readFromNBT(compound);
    }
}
