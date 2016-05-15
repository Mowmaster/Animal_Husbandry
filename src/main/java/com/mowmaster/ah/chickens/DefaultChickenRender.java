package com.mowmaster.ah.chickens;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;


public class DefaultChickenRender implements IRenderFactory
{
    @Override
    public Render createRenderFor(RenderManager manager)
    {
        return new ahEntityChickenRender(manager);
    }
}
