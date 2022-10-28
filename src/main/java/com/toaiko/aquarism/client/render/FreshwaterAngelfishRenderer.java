package com.toaiko.aquarism.client.render;

import com.toaiko.aquarism.Aquarism;
import com.toaiko.aquarism.client.model.FreshwaterAngelfishModel;
import com.toaiko.aquarism.entities.FreshwaterAngelfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FreshwaterAngelfishRenderer extends MobRenderer<FreshwaterAngelfishEntity, FreshwaterAngelfishModel<FreshwaterAngelfishEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Aquarism.MOD_ID, "textures/entity/Freshwater_Angelfish.png");

    public FreshwaterAngelfishRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new FreshwaterAngelfishModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(FreshwaterAngelfishEntity entity) {
        return TEXTURE;
    }
}
