package com.mowmaster.ah.chickens;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.Set;

import static com.mowmaster.ah.item.ItemReg.egg_default;

public class ahEntityChicken extends EntityChicken
{

    private static final Set<Item> ahBreedingMaterial = Sets.newHashSet(new Item[] {Items.iron_ingot}); //Breeding item required???
    public float wingRotation;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float wingRotDelta = 1.0F;
    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;
    public boolean chickenJockey;

    public ahEntityChicken(World worldIn)
    {
        super(worldIn);
        this.setSize(0.4F, 0.7F);
        this.timeUntilNextEgg = this.rand.nextInt(10000) + 10000; // Time In ticks??? 6000 = 5minutes
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }
    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, ahBreedingMaterial));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    @Override
    public float getEyeHeight()
    {
        return this.height;
    }
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate()
    {
      super.onLivingUpdate();
        this.field_70888_h = this.wingRotation;
        this.field_70884_g = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
        this.destPos = MathHelper.clamp_float(this.destPos, 0.0F, 1.0F);

        if (!this.onGround && this.wingRotDelta < 1.0F)
        {
            this.wingRotDelta = 1.0F;
        }

        this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.wingRotation += this.wingRotDelta * 2.0F;
                                                                                            //Egg Laying here
        if (!this.worldObj.isRemote && !this.isChild() && !this.isChickenJockey() && --this.timeUntilNextEgg <= 0)
        {
            this.playSound(SoundEvents.entity_chicken_egg, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            // drop item was Items.egg but changed to our default type - for now
            this.dropItem(egg_default, 1);
            this.timeUntilNextEgg = this.rand.nextInt(10000) + 10000;
        }
    }
    @Override
    public void fall(float distance, float damageMultiplier)
    {
    }
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEvents.entity_chicken_ambient;
    }
    @Override
    protected SoundEvent getHurtSound()
    {
        return SoundEvents.entity_chicken_hurt;
    }
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.entity_chicken_death;
    }
    @Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(SoundEvents.entity_chicken_step, 0.15F, 1.0F);
    }
    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_CHICKEN;
    }
    @Override
    //Takes Care of baby chickens???
    public EntityChicken createChild(EntityAgeable ageable)
    {
        return new ahEntityChicken(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack != null && ahBreedingMaterial.contains(stack.getItem());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
 //   @Override
 //   public void readEntityFromNBT(NBTTagCompound tagCompund)
 //   {
 //       super.readEntityFromNBT(tagCompund);
 //       this.chickenJockey = tagCompund.getBoolean("IsChickenJockey");
//
 //       if (tagCompund.hasKey("EggLayTime"))
  //      {
//
  //          // More egg laying
 //           this.timeUntilNextEgg = tagCompund.getInteger("EggLayTime");
  //      }
  //  }

    /**
     * Get the experience points the entity currently has.
     */
//    @Override
//    protected int getExperiencePoints(EntityPlayer player)
//    {
//        return this.isChickenJockey() ? 10 : super.getExperiencePoints(player);
//    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        //tagCompound.setBoolean("IsChickenJockey", this.chickenJockey);
        tagCompound.setInteger("EggLayTime", this.timeUntilNextEgg);
    }
/**
    //Determines if an entity can be despawned, used on idle far away entities

    @Override
    protected boolean canDespawn()
    {
        return this.isChickenJockey() && !this.isBeingRidden();
    }
    @Override
    public void updatePassenger(Entity passenger)
    {
        super.updatePassenger(passenger);
        float f = MathHelper.sin(this.renderYawOffset * 0.017453292F);
        float f1 = MathHelper.cos(this.renderYawOffset * 0.017453292F);
        float f2 = 0.1F;
        float f3 = 0.0F;
        passenger.setPosition(this.posX + (double)(f2 * f), this.posY + (double)(this.height * 0.5F) + passenger.getYOffset() + (double)f3, this.posZ - (double)(f2 * f1));

        if (passenger instanceof EntityLivingBase)
        {
            ((EntityLivingBase)passenger).renderYawOffset = this.renderYawOffset;
        }
    }


    //Determines if this chicken is a jokey with a zombie riding it.

    @Override
    public boolean isChickenJockey()
    {
        return this.chickenJockey;
    }


    //Sets whether this chicken is a jockey or not.

    @Override
    public void setChickenJockey(boolean jockey)
    {
        this.chickenJockey = jockey;
    }
*/
}
