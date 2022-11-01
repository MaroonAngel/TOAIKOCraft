package com.toaiko.toaikocraft.entities;

import com.toaiko.toaikocraft.TOAIKOCraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Locale;

public class OscarEntity extends TOAIKOFishEntity {

    private static final String TEXTURE_PATH = "textures/entity/fish/oscar/";
    private static final DataParameter<Integer> DATA_ID_TYPE_VARIANT = EntityDataManager.defineId(OscarEntity.class, DataSerializers.INT);
    private static final ResourceLocation[] VARIANT_TEXTURE_LOCATIONS = new ResourceLocation[] {
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "albino_copper.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "albino_copper_tiger.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "albino_red.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "albino_red_tiger.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "black.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "bumble_bee.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "copper.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "copper_tiger.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "golden.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "lemon.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "lemon_tiger.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "red.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "red_tiger.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "super_red.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "wild.png")
    };

    public OscarEntity(EntityType<? extends OscarEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.0d);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    protected ItemStack getBucketItemStack() {
        return new ItemStack(Items.WATER_BUCKET);
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putInt("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundNBT tags) {
        super.readAdditionalSaveData(tags);
        this.setVariant(tags.getInt("Variant"));
    }

    public int getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant);
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getVariantTextureLocation() {
        return VARIANT_TEXTURE_LOCATIONS[this.getVariant()];
    }

    protected void saveToBucketTag(ItemStack bucket) {
        super.saveToBucketTag(bucket);
        CompoundNBT compoundnbt = bucket.getOrCreateTag();
        compoundnbt.putInt("BucketVariantTag", this.getVariant());
    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT nbt) {
        entityData = super.finalizeSpawn(world, difficulty, reason, entityData, nbt);
        if (nbt != null && nbt.contains("BucketVariantTag", 3)) {
            this.setVariant(nbt.getInt("BucketVariantTag"));
            return entityData;
        } else {
            this.setVariant(this.random.nextInt(OscarEntity.Type.values().length));
            return entityData;
        }
    }

    static enum Type {

        ALBINO_COPPER(0),
        ALBINO_COPPER_TIGER(1),
        ALBINO_RED(2),
        ALBINO_RED_TIGER(3),
        BLACK(4),
        BUMBLE_BEE(5),
        COPPER(6),
        COPPER_TIGER(7),
        GOLDEN(8),
        LEMON(9),
        LEMON_TIGER(10),
        RED(11),
        RED_TIGER(12),
        SUPER_RED(13),
        WILD(14);

        private static final OscarEntity.Type[] VALUES = values();

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
