package com.mowmaster.ah.item;

import com.mowmaster.ah.reference.reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;


public final class ItemRendReg
{
    public static void registerItemRenderer()
    {
        reg(ItemReg.egg_emerald);
        reg(ItemReg.egg_diamond);
        reg(ItemReg.egg_gold);
        reg(ItemReg.egg_iron);
        reg(ItemReg.egg_redstone);
        reg(ItemReg.egg_coal);
        reg(ItemReg.egg_lapis);
        reg(ItemReg.egg_glowstone);
        reg(ItemReg.egg_quartz);
        reg(ItemReg.egg_default);



    }

    public static void reg(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
