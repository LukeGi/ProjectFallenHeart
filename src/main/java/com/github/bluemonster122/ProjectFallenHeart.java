package com.github.bluemonster122;

import com.github.bluemonster122.feature.FeatureManager;
import com.github.bluemonster122.proxy.IProxy;
import com.github.bluemonster122.registerer.BlockRegisterer;
import com.github.bluemonster122.registerer.ItemRegisterer;
import com.github.bluemonster122.registerer.TileEntityRegisterer;
import com.github.bluemonster122.util.IInitalize;
import com.github.bluemonster122.util.MessageLoading;
import com.github.bluemonster122.util.ModInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
public class ProjectFallenHeart implements IInitalize {

    @Instance
    public static ProjectFallenHeart INSTANCE;

    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY_CLASS, serverSide = ModInfo.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    public static BlockRegisterer blockRegisterer = new BlockRegisterer();
    public static TileEntityRegisterer tileRegisterer = new TileEntityRegisterer();
    public static ItemRegisterer itemRegisterer = new ItemRegisterer();
    public static FeatureManager featureManager = new FeatureManager();
    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info(MessageLoading.getMessage(0, true));
        featureManager.preInit(event);
        logger.info(MessageLoading.getMessage(0, false));
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info(MessageLoading.getMessage(1, true));
        featureManager.init(event);
        logger.info(MessageLoading.getMessage(1, false));
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info(MessageLoading.getMessage(2, true));
        featureManager.postInit(event);
        logger.info(MessageLoading.getMessage(2, false));
    }
}
