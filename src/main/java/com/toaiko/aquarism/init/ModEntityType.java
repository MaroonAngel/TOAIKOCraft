package com.toaiko.aquarism.init;

import com.toaiko.aquarism.entities.FreshwaterAngelfishEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.toaiko.aquarism.Aquarism;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Aquarism.MOD_ID);
    public static final RegistryObject<EntityType<FreshwaterAngelfishEntity>> FRESHWATER_ANGELFISH = ENTITIES.register("freshwater_angelfish",
            () -> EntityType.Builder.of(FreshwaterAngelfishEntity::new, EntityClassification.WATER_CREATURE)
                .sized(0.5f, 0.3f)
                .build(new ResourceLocation(Aquarism.MOD_ID, "freshwater_angelfish").toString()));
}
