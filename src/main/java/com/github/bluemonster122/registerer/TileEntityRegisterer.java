package com.github.bluemonster122.registerer;

import com.github.bluemonster122.block.PFHTileBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegisterer {
    public TileEntityRegisterer() {
    }

    public void registerTile(PFHTileBlock block) {
        GameRegistry.registerTileEntity(block.getTileClass(), block.getRegistryName().getResourcePath());
    }
}
