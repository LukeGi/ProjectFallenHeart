package com.github.bluemonster122.registerer;

import com.github.bluemonster122.ProjectFallenHeart;
import com.github.bluemonster122.block.PFHTileBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegisterer {
    public BlockRegisterer() {
    }

    public void registerBlock(Block block) {
        if (block != null) {
            GameRegistry.register(block);
            ItemBlock item = new ItemBlock(block);
            item.setRegistryName(block.getRegistryName());
            ProjectFallenHeart.itemRegisterer.registerItem(item);
            if (block instanceof PFHTileBlock) {
                ProjectFallenHeart.tileRegisterer.registerTile((PFHTileBlock) block);
            }
        }
    }

}
