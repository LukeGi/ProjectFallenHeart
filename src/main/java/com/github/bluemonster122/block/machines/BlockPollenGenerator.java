package com.github.bluemonster122.block.machines;

import com.github.bluemonster122.block.PFHTileBlock;
import com.github.bluemonster122.tileentity.TileEntityPollenGenerator;
import com.github.bluemonster122.util.ModInfo;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPollenGenerator extends PFHTileBlock {
    public BlockPollenGenerator() {
        super(Material.IRON);
        setRegistryName(ModInfo.MOD_ID, "pollen_generator");
        setUnlocalizedName(getRegistryName().getResourcePath());
    }

    @Override
    public Class<? extends TileEntity> getTileClass() {
        return TileEntityPollenGenerator.class;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPollenGenerator();
    }
}
