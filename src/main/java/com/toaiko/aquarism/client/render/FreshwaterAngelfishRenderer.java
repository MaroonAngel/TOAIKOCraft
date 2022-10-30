package com.toaiko.aquarism.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.toaiko.aquarism.Aquarism;
import com.toaiko.aquarism.client.model.FreshwaterAngelfishModel;
import com.toaiko.aquarism.entities.FreshwaterAngelfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class FreshwaterAngelfishRenderer extends MobRenderer<FreshwaterAngelfishEntity, FreshwaterAngelfishModel<FreshwaterAngelfishEntity>> {

    public FreshwaterAngelfishRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new FreshwaterAngelfishModel<>(), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(FreshwaterAngelfishEntity entity) {
        return entity.getVariantTextureLocation();
    }

    protected void setupRotations(FreshwaterAngelfishEntity fish, MatrixStack matrices, float xRot, float yRot, float zRot) {
        super.setupRotations(fish, matrices, xRot, yRot, zRot);
        float f = 4.3F * MathHelper.sin(0.6F * xRot);
        matrices.mulPose(Vector3f.YP.rotationDegrees(f));
        if (!fish.isInWater()) {
            matrices.translate((double)0.1F, (double)0.1F, (double)-0.1F);
            matrices.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }
}
