package com.github.bluemonster122.registerer;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegisterer {
    public ItemRegisterer() {
    }

    public void registerItem(Item item) {
        if (item != null) {
            GameRegistry.register(item);
            registerItemModel(item);
        }
    }

    private void registerItemModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
