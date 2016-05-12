//package com.mowmaster.ah.configuration;

//import net.minecraftforge.fml.common.FMLCommonHandler;

//public class configFile
//{

//    public static boolean craftableCrystals;
//    public static final boolean CRAFTABLECRYSTALS = false;
//    public static final String CRAFTABLECRYSTALS_NAME = "Enable The Crafting Of Crystals";
//
//
//    public static void syncConfig()
//    {
//        FMLCommonHandler.instance().bus().register(ah.instance);
//
//        final String RECIPIES = ah.config.CATEGORY_GENERAL + ah.config.CATEGORY_SPLITTER + "Recipies";
//        ah.config.addCustomCategoryComment(RECIPIES, "Craftable Crystals???");
//        craftableCrystals = dust.config.get(RECIPIES, CRAFTABLECRYSTALS_NAME, CRAFTABLECRYSTALS).getBoolean(CRAFTABLECRYSTALS);
//
//
//
//        if (dust.config.hasChanged())
//        {
//    dust.config.save();
//        }
//    }
//
//}
