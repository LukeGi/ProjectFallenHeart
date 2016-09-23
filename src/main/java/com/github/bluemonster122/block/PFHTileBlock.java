package com.github.bluemonster122.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;

public abstract class PFHTileBlock extends PFHBlock implements ITileEntityProvider {
    public PFHTileBlock(Material materialIn) {
        super(materialIn);
    }

    public abstract Class<? extends TileEntity> getTileClass();
}
