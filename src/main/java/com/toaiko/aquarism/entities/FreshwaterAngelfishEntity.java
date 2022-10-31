package com.toaiko.aquarism.entities;

import com.toaiko.aquarism.Aquarism;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
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

import javax.annotation.Nullable;
import java.util.Locale;

public class FreshwaterAngelfishEntity extends TOAIKOGroupFishEntity {
    private static final DataParameter<Integer> DATA_ID_TYPE_VARIANT = EntityDataManager.defineId(FreshwaterAngelfishEntity.class, DataSerializers.INT);
    private static final ResourceLocation[] VARIANT_TEXTURE_LOCATIONS = new ResourceLocation[] {
            new ResourceLocation(Aquarism.MOD_ID,"textures/entity/fish/freshwater_angelfish/koi.png"),
            new ResourceLocation(Aquarism.MOD_ID,"textures/entity/fish/freshwater_angelfish/striped.png"),
            new ResourceLocation(Aquarism.MOD_ID,"textures/entity/fish/freshwater_angelfish/black.png"),
            new ResourceLocation(Aquarism.MOD_ID,"textures/entity/fish/freshwater_angelfish/marble.png"),
            new ResourceLocation(Aquarism.MOD_ID,"textures/entity/fish/freshwater_angelfish/koi_marble.png")
    };

    private boolean isSchool = true;

    public FreshwaterAngelfishEntity(EntityType<? extends FreshwaterAngelfishEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D);
    }

    public int getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @OnlyIn(Dist.CLIENT)
    public static String getFishTypeName(int variant) {
        return "entity.aquarism.freshwater_angelfish." + FreshwaterAngelfishEntity.Type.getVariantName(variant);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundNBT tags) {
        super.readAdditionalSaveData(tags);
        this.setVariant(tags.getInt("Variant"));
    }

    public void setVariant(int variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant);
    }

    public boolean isMaxGroupSizeReached(int p_204209_1_) {
        return !this.isSchool;
    }

    protected void saveToBucketTag(ItemStack bucket) {
        super.saveToBucketTag(bucket);
        CompoundNBT compoundnbt = bucket.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
    }

    protected ItemStack getBucketItemStack() {
        return new ItemStack(Items.TROPICAL_FISH_BUCKET);
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT nbt) {
        entityData = super.finalizeSpawn(world, difficulty, reason, entityData, nbt);
        if (nbt != null && nbt.contains("BucketVariantTag", 3)) {
            this.setVariant(nbt.getInt("BucketVariantTag"));
            return entityData;
        } else {
            this.setVariant(this.random.nextInt(Type.values().length));
            return entityData;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getVariantTextureLocation() {
        return VARIANT_TEXTURE_LOCATIONS[this.getVariant()];
    }

    static enum Type {
        KOI(0),
        STRIPED(1),
        BLACK(2),
        MARBLE(3),
        KOI_MARBLE(4);

        private static final FreshwaterAngelfishEntity.Type[] VALUES = values();

        private final int type;

        private Type(int type) {
            this.type = type;
        }

        public int getType() { return this.type; }

        @OnlyIn(Dist.CLIENT)
        public static String getVariantName(int type) {
            return VALUES[type].getName().replace('_', ' ');
        }

        @OnlyIn(Dist.CLIENT)
        public String getName() {
            return this.name().toLowerCase(Locale.ROOT);
        }
    }
}
