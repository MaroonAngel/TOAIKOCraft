package com.toaiko.aquarism.client.render;

import com.toaiko.aquarism.client.model.FreshwaterAngelfishModel;
import com.toaiko.aquarism.entities.FreshwaterAngelfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FreshwaterAngelfishRenderer extends MobRenderer<FreshwaterAngelfishEntity, FreshwaterAngelfishModel<FreshwaterAngelfishEntity>> {

    public FreshwaterAngelfishRenderer(EntityRendererManager p_i50961_1_, FreshwaterAngelfishModel<FreshwaterAngelfishEntity> p_i50961_2_, float p_i50961_3_) {
        super(p_i50961_1_, p_i50961_2_, p_i50961_3_);
    }



    @Override
    public ResourceLocation getTextureLocation(FreshwaterAngelfishEntity entity) {
        return null;
    }
}
