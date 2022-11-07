package com.toaiko.toaikocraft.init;

import com.google.common.collect.Lists;
import com.toaiko.toaikocraft.TOAIKOCraft;
import com.toaiko.toaikocraft.entity.FishType;
import com.toaiko.toaikocraft.entity.TOAIKOGroupFishEntity;
import com.toaiko.toaikocraft.item.TOAIKOFishBucketItem;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = TOAIKOCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TOAIKOFishInit {
    public static List<EntityType<TOAIKOGroupFishEntity>> fishEntities = Lists.newArrayList();

    public static EntityType<TOAIKOGroupFishEntity> registerFish(FishType type) {
        String name = type.name().toLowerCase();
        EntityType<TOAIKOGroupFishEntity> newFishEntity = EntityType.Builder.of(
                        TOAIKOGroupFishEntity::new, EntityClassification.WATER_AMBIENT)
                .sized(type.getWidth(), type.getHeight())
                .build(new ResourceLocation(TOAIKOCraft.MOD_ID, name).toString());


        fishEntities.add(newFishEntity);
        RegistryObject<EntityType<TOAIKOGroupFishEntity>> fishEntity = TOAIKOEntityTypes.ENTITY_TYPES.register(name, () -> newFishEntity);
        TOAIKOGroupFishEntity.TYPES.put(newFishEntity, type);

        return newFishEntity;
    }

    @SubscribeEvent
    public static void buildFishAttributes(EntityAttributeCreationEvent event) {
        for (EntityType<TOAIKOGroupFishEntity> entity : TOAIKOFishInit.fishEntities) {
            event.put(entity, TOAIKOGroupFishEntity.setCustomAttributes(TOAIKOGroupFishEntity.TYPES.get(entity)).build());
        }
    }
}
