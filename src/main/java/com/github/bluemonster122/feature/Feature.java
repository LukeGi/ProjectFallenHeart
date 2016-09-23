package com.github.bluemonster122.feature;

import com.github.bluemonster122.ProjectFallenHeart;
import com.github.bluemonster122.block.PFHBlock;
import com.github.bluemonster122.item.PFHItems;
import com.github.bluemonster122.util.MessageLoading;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class Feature implements IFeature {

    protected List<PFHBlock> blocks = new ArrayList<>();
    protected List<PFHItems> items = new ArrayList<>();

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ProjectFallenHeart.logger.info(MessageLoading.getMessage(0, true, getName()));
        initBlocks();
        initItems();
        blocks.parallelStream().forEach(b -> {
            ProjectFallenHeart.blockRegisterer.registerBlock(b);
            b.setCreativeTab(getTab());
        });
        items.parallelStream().forEach(b -> {
            ProjectFallenHeart.itemRegisterer.registerItem(b);
            b.setCreativeTab(getTab());
        });
        ProjectFallenHeart.logger.info(MessageLoading.getMessage(0, false, getName()));
    }

    @Override
    public void init(FMLInitializationEvent event) {
        ProjectFallenHeart.logger.info(MessageLoading.getMessage(1, true, getName()));
        registerRecipes();
        ProjectFallenHeart.logger.info(MessageLoading.getMessage(1, false, getName()));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        ProjectFallenHeart.logger.info(MessageLoading.getMessage(2, true, getName()));
        ProjectFallenHeart.logger.info(MessageLoading.getMessage(2, false, getName()));
    }

    public abstract void initBlocks();

    public abstract void initItems();

    public abstract void registerRecipes();

    @Override
    public CreativeTabs getTab() {
        return CreativeTabs.BUILDING_BLOCKS;
    }
}
