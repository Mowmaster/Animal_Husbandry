package com.mowmaster.ah.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


public final class ItemReg
{
    public static Item egg_emerald;
    public static Item egg_diamond;
    public static Item egg_gold;
    public static Item egg_iron;
    public static Item egg_coal;
    public static Item egg_lapis;
    public static Item egg_redstone;
    public static Item egg_glowstone;
    public static Item egg_quartz;
    public static Item egg_default;


    public static void regEggs()
    {
        GameRegistry.register(egg_emerald = new ahEggs("egg_emerald").setRegistryName("egg_emerald"));
        GameRegistry.register(egg_diamond = new ahEggs("egg_diamond").setRegistryName("egg_diamond"));
        GameRegistry.register(egg_gold = new ahEggs("egg_gold").setRegistryName("egg_gold"));
        GameRegistry.register(egg_iron = new ahEggs("egg_iron").setRegistryName("egg_iron"));
        GameRegistry.register(egg_coal = new ahEggs("egg_coal").setRegistryName("egg_coal"));
        GameRegistry.register(egg_redstone = new ahEggs("egg_redstone").setRegistryName("egg_redstone"));
        GameRegistry.register(egg_lapis = new ahEggs("egg_lapis").setRegistryName("egg_lapis"));
        GameRegistry.register(egg_glowstone = new ahEggs("egg_glowstone").setRegistryName("egg_glowstone"));
        GameRegistry.register(egg_quartz = new ahEggs("egg_quartz").setRegistryName("egg_quartz"));
        GameRegistry.register(egg_default = new ahEggs("egg_default").setRegistryName("egg_default"));
    }
}
