package com.mowmaster.ah;

import com.mowmaster.ah.events.ModEvents;
import com.mowmaster.ah.item.ItemReg;
import com.mowmaster.ah.item.ItemRendReg;
import com.mowmaster.ah.proxies.CommonProxy;
import com.mowmaster.ah.reference.reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = reference.MOD_ID, name = reference.MOD_NAME, version = reference.VERSION)
public class ah
{
    @Mod.Instance(reference.MOD_ID)
    public static ah instance;

    @SidedProxy(clientSide = reference.CLIENTSIDE, serverSide = reference.SERVERSIDE)
    public static CommonProxy proxy;

    public static Configuration config;

    //@SubscribeEvent
    //public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
    //    if (event.modID.equals(reference.MOD_ID)) {
    //        configFile.syncConfig();
    //
    //    }
    //}

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //config = new Configuration(event.getSuggestedConfigurationFile());
        //configFile.syncConfig();

        ItemReg.regEggs();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        ItemRendReg.registerItemRenderer();

        ModEvents handler = new ModEvents();
        MinecraftForge.EVENT_BUS.register(handler);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
