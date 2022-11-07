package com.toaiko.toaikocraft.entity;

import com.toaiko.toaikocraft.TOAIKOCraft;
import com.toaiko.toaikocraft.item.TOAIKOFishBucketItem;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;

import javax.annotation.Nullable;
import java.util.HashMap;

public class TOAIKOGroupFishEntity extends AbstractGroupFishEntity {

    public static final HashMap<EntityType<TOAIKOGroupFishEntity>, TOAIKOFishBucketItem> BUCKETS = new HashMap<>();
    public static final HashMap<EntityType<TOAIKOGroupFishEntity>, FishType> TYPES = new HashMap<>();

    private static final DataParameter<String> DATA_ID_TYPE_VARIANT = EntityDataManager.defineId(TOAIKOGroupFishEntity.class, DataSerializers.STRING);;
    private boolean isSchool = true;

    public TOAIKOGroupFishEntity(EntityType<? extends AbstractGroupFishEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(FishType type) {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, type.getHealth())
                .add(ForgeMod.SWIM_SPEED.get(), type.getSwimSpeed());
    }

    @OnlyIn(Dist.CLIENT)
    public String getFishTypeName() {
        return getFishType().toString().toLowerCase();
    }

    public FishType getFishType() {
        return TYPES.get(this.getType());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, "");
    }

    protected ItemStack getBucketItemStack() {
        return new ItemStack(BUCKETS.get(this.getType()));
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putString("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundNBT tags) {
        super.readAdditionalSaveData(tags);
        String vari = tags.getString("Variant");
        this.setVariant(vari);
    }

    public String getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    public void setVariant(String variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant);
    }

    protected void setRandomVariant() {
        this.setVariant(this.getFishType().getVariants()[this.random.nextInt(this.getFishType().getVariants().length)]);
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getVariantTextureLocation() {
        if (this.getVariant() == "") {
            this.setRandomVariant();
        }
        return new ResourceLocation(TOAIKOCraft.MOD_ID, "textures/entity/fish/" + this.getFishTypeName() + "/" + this.getVariant() + ".png");
    }

    protected void saveToBucketTag(ItemStack bucket) {
        super.saveToBucketTag(bucket);
        CompoundNBT compoundnbt = bucket.getOrCreateTag();
        compoundnbt.putString("BucketVariantTag", this.getVariant());
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT nbt) {
        entityData = super.finalizeSpawn(world, difficulty, reason, entityData, nbt);

        if (nbt != null && nbt.contains("BucketVariantTag", nbt.getTagType("BucketVariantTag"))) {
            this.setVariant(nbt.getString("BucketVariantTag"));
        } else {
            this.setRandomVariant();
        }
        return entityData;
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
