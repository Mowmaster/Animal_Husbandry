package com.mowmaster.ah.item;

import com.mowmaster.ah.configuration.ahCreativeTab;
import com.mowmaster.ah.reference.reference;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by KingMowmaster on 5/12/2016.
 */
public class ahEggs extends ItemAH
{
    public ahEggs(String unloc)
    {
        super(unloc);

        this.maxStackSize = 16;
        this.setCreativeTab(ahCreativeTab.tabEggs);

    }
}

