package com.toaiko.toaikocraft.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.toaiko.toaikocraft.client.model.OscarModel;
import com.toaiko.toaikocraft.entity.OscarEntity;
import com.toaiko.toaikocraft.entity.TOAIKOGroupFishEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

import javax.annotation.Nullable;

public class OscarRenderer extends MobRenderer<TOAIKOGroupFishEntity, OscarModel<TOAIKOGroupFishEntity>> {

    public OscarRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new OscarModel<>(), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(TOAIKOGroupFishEntity p_110775_1_) {
        return null;
    }


    protected void setupRotations(TOAIKOGroupFishEntity fish, MatrixStack matrices, float xRot, float yRot, float zRot) {
        super.setupRotations(fish, matrices, xRot, yRot, zRot);
        float f = 2F * MathHelper.cos(0.4F * xRot);
        matrices.mulPose(Vector3f.YP.rotationDegrees(f));
        if (!fish.isInWater()) {
            matrices.translate((double)0.1F, (double)0.1F, (double)-0.1F);
            matrices.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }

    @Nullable
    @Override
    protected RenderType getRenderType(TOAIKOGroupFishEntity p_230496_1_, boolean p_230496_2_, boolean p_230496_3_, boolean p_230496_4_) {
        return super.getRenderType(p_230496_1_, p_230496_2_, true, p_230496_4_);
    }

}

