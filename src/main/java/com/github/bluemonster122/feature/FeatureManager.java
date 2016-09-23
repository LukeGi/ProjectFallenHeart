package com.github.bluemonster122.feature;

import com.github.bluemonster122.util.IInitalize;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager implements IInitalize {

    List<IFeature> features = new ArrayList<>();

    {
        features.add(new FeatureMachines());
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        features.forEach(f -> f.preInit(event));
    }

    @Override
    public void init(FMLInitializationEvent event) {
        features.forEach(f -> f.init(event));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        features.forEach(f -> f.postInit(event));
    }
}
