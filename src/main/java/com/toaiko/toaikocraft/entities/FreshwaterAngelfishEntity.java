package com.toaiko.toaikocraft.entities;

import com.toaiko.toaikocraft.TOAIKOCraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Locale;

public class FreshwaterAngelfishEntity extends TOAIKOGroupFishEntity {
    private static final String TEXTURE_PATH = "textures/entity/fish/freshwater_angelfish/";
    private static final DataParameter<Integer> DATA_ID_TYPE_VARIANT = EntityDataManager.defineId(FreshwaterAngelfishEntity.class, DataSerializers.INT);
    private static final ResourceLocation[] VARIANT_TEXTURE_LOCATIONS = new ResourceLocation[] {
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "albino.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "black.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "blue_pinoy.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "blushing.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "chocolate.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "fluorescent_green.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "fluorescent_pink.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "golden.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "koi.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "koi_marble.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "leopard.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "marble.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "panda.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "platinum.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "red_cap.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "red_devil.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "smokey.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "striped.png"),
            new ResourceLocation(TOAIKOCraft.MOD_ID,TEXTURE_PATH + "sunset.png"),
    };

    public FreshwaterAngelfishEntity(EntityType<? extends FreshwaterAngelfishEntity> type, World world) {
        super(type, world);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5.0D);
    }

    @OnlyIn(Dist.CLIENT)
    public static String getFishTypeName(int variant) {
        return "entity.toaikocraft.freshwater_angelfish." + FreshwaterAngelfishEntity.Type.getVariantName(variant);
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
        int vari = tags.getInt("Variant");
        if (vari > Type.values().length - 1)
            vari = 0;
        this.setVariant(vari);
    }

    public int getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant);
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getVariantTextureLocation() {
        if (this.getVariant() > Type.values().length) {
            this.setVariant(0);
        }
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
            this.setVariant(this.random.nextInt(FreshwaterAngelfishEntity.Type.values().length));
            return entityData;
        }
    }

    static enum Type {
        ALBINO(0),
        BLACK(1),
        BLUE_PINOY(2),
        BLUSHING(3),
        CHOCOLATE(4),
        FLUORESCENT_GREEN(5),
        FLUORESCENT_PINK(6),
        GOLDEN(7),
        KOI(8),
        KOI_MARBLE(9),
        LEOPARD(10),
        MARBLE(11),
        PANDA(12),
        PLATINUM(13),
        RED_CAP(14),
        RED_DEVIL(15),
        SMOKEY(16),
        STRIPED(17),
        SUNSET(18);

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
