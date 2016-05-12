package com.mowmaster.ah.configuration;


import com.mowmaster.ah.item.ItemReg;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;


public class ahCreativeTab
{
    public static final CreativeTabs tabEggs = new CreativeTabs("tabEggs") {
        @Override
        public Item getTabIconItem() {
            return ItemReg.egg_diamond;
        }
    };
}
