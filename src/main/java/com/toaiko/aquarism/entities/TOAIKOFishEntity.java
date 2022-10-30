package com.toaiko.aquarism.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.world.World;

public abstract class TOAIKOFishEntity extends AbstractFishEntity {

    public TOAIKOFishEntity(EntityType<? extends AbstractFishEntity> type, World world) {
        super(type, world);
    }
}
