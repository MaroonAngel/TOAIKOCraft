package com.toaiko.toaikocraft.init;

import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.toaiko.toaikocraft.TOAIKOCraft;

public class TOAIKOEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, TOAIKOCraft.MOD_ID);

    /*
    public static final RegistryObject<EntityType<FreshwaterAngelfishEntity>> FRESHWATER_ANGELFISH = ENTITY_TYPES.register("freshwater_angelfish",
            () -> EntityType.Builder.of(FreshwaterAngelfishEntity::new, EntityClassification.WATER_CREATURE)
                .sized(0.3f, 0.4f)
                .build(new ResourceLocation(TOAIKOCraft.MOD_ID, "freshwater_angelfish").toString()));

    public static final RegistryObject<EntityType<OscarEntity>> OSCAR = ENTITY_TYPES.register("oscar",
            () -> EntityType.Builder.of(OscarEntity::new, EntityClassification.WATER_CREATURE)
                    .sized(0.6f, 0.3f)
                    .build(new ResourceLocation(TOAIKOCraft.MOD_ID, "oscar").toString()));

     */
}
