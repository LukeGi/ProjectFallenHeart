package com.github.bluemonster122.feature;

import com.github.bluemonster122.block.PFHTileBlock;
import com.github.bluemonster122.block.machines.BlockPollenGenerator;
import com.github.bluemonster122.util.ModInfo;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FeatureMachines extends Feature {
    private CreativeTabs tab = new CreativeTabs(ModInfo.MOD_NAME + ';' + getName()) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.FURNACE);
        }
    };
    private PFHTileBlock pollen_generator;

    @Override
    public String getName() {
        return "Machines Module";
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        blocks.parallelStream().forEach(b -> b.setCreativeTab(getTab()));
    }

    @Override
    public void initBlocks() {
        blocks.add(pollen_generator = new BlockPollenGenerator());
    }

    @Override
    public void initItems() {

    }

    @Override
    public void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(pollen_generator, 1), "LIL", "IDI", "LIL", 'L', new ItemStack(Blocks.SKULL), 'D', new ItemStack(Blocks.DIRT), 'I', new ItemStack(Blocks.IRON_BLOCK));
    }

    @Override
    public CreativeTabs getTab() {
        return tab;
    }
}
