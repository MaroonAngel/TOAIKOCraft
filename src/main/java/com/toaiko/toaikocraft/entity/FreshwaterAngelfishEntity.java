package com.toaiko.toaikocraft.entity;

import com.toaiko.toaikocraft.TOAIKOCraft;
import com.toaiko.toaikocraft.item.TOAIKOFishBucketItem;
import net.minecraft.entity.EntityType;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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

    protected static TOAIKOFishBucketItem bucketItem = null;

    public FreshwaterAngelfishEntity(EntityType<? extends FreshwaterAngelfishEntity> type, World world) {
        super(type, world);
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
