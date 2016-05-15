package com.mowmaster.ah.chickens;

import com.mowmaster.ah.reference.reference;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;


public class ahChickenRegister
{
    public static void regChickens()
    {
        //First Line should be in client proxy
        RenderingRegistry.registerEntityRenderingHandler(ahEntityChicken.class, new DefaultChickenRender());
        EntityRegistry.registerModEntity(ahEntityChicken.class,"chicken_default",1, reference.MOD_ID,16,5,true);
        EntityRegistry.registerEgg (ahEntityChicken.class,0xFFFFFF, 0xFFFFFF );
        EntityRegistry.addSpawn(ahEntityChicken.class,100,50,100, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
    }
}
