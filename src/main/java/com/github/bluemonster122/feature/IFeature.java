package com.github.bluemonster122.feature;

import com.github.bluemonster122.util.IInitalize;
import net.minecraft.creativetab.CreativeTabs;

public interface IFeature extends IInitalize {
    String getName();

    CreativeTabs getTab();
}
