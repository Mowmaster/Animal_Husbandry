package com.mowmaster.ah.chickens;

import com.mowmaster.ah.reference.reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ahEntityChickenRender extends RenderLiving
{
    protected ResourceLocation chickenTexture;

    public ahEntityChickenRender(RenderManager manager)
    {
        super(manager, new ModelChicken(),0.5F);
        setEntityTexture();
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f)
    {
        preRenderCallbackSerpent((ahEntityChicken) entity, f);
    }

    protected void preRenderCallbackSerpent(ahEntityChicken entity, float f)
    {
        // some people do some G11 transformations or blends here, like you can do
        // GL11.glScalef(2F, 2F, 2F); to scale up the entity
        // which is used for Slime entities.  I suggest having the entity cast to
        // your custom type to make it easier to access fields from your
        // custom entity, eg. GL11.glScalef(entity.scaleFactor, entity.scaleFactor,
        // entity.scaleFactor);
    }

    protected void setEntityTexture()
    {
        chickenTexture = new ResourceLocation(reference.MOD_ID + ":textures/entity/chicken_default.png");
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called
     * unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return chickenTexture;
    }
}


