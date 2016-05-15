package com.mowmaster.ah.item;

import com.mowmaster.ah.chickens.ahEntityChicken;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by KingMowmaster on 5/15/2016.
 */
public class ahEntityEgg extends EntityEgg
{
    public ahEntityEgg(World worldIn)
    {
        super(worldIn);
    }

    public ahEntityEgg(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public ahEntityEgg(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
        {
            int i = 1;

            if (this.rand.nextInt(32) == 0)
            {
                i = 4;
            }

            for (int j = 0; j < i; ++j)
            {
                EntityChicken entitychicken = new ahEntityChicken(this.worldObj);
                entitychicken.setGrowingAge(-24000);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entitychicken);
            }
        }

        double d0 = 0.08D;

        for (int k = 0; k < 8; ++k)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(Items.egg)});
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
