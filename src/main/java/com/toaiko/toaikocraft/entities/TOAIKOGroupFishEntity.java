package com.toaiko.toaikocraft.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public abstract class TOAIKOGroupFishEntity extends AbstractGroupFishEntity {

    private static final DataParameter<Integer> DATA_ID_TYPE_VARIANT = null;
    private static final ResourceLocation[] VARIANT_TEXTURE_LOCATIONS = null;
    private boolean isSchool = true;

    public TOAIKOGroupFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World world) {
        super(type, world);
    }


    @Override
    protected ItemStack getBucketItemStack() {
        return new ItemStack(Items.SALMON_BUCKET);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.TROPICAL_FISH_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.TROPICAL_FISH_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.TROPICAL_FISH_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.TROPICAL_FISH_FLOP;
    }



    public boolean isMaxGroupSizeReached(int p_204209_1_) {
        return !this.isSchool;
    }



    public boolean removeWhenFarAway(double p_213397_1_) {
        return false; // DANGEROUS; REMOVE THIS IF THEY SPAWN NATURALLY
    }


}
