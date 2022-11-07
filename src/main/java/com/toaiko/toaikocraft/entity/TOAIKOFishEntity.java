package com.toaiko.toaikocraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class TOAIKOFishEntity extends AbstractFishEntity {

    public TOAIKOFishEntity(EntityType<? extends AbstractFishEntity> type, World world) {
        super(type, world);
    }











    protected ItemStack getBucketItemStack() {
        return new ItemStack(Items.WATER_BUCKET);
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

    public boolean removeWhenFarAway(double p_213397_1_) {
        return false; // DANGEROUS; REMOVE THIS IF THEY SPAWN NATURALLY
    }
}
