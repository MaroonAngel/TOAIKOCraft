package com.toaiko.toaikocraft.client.render;

        import com.mojang.blaze3d.matrix.MatrixStack;
        import com.toaiko.toaikocraft.client.model.FreshwaterAngelfishModel;
        import com.toaiko.toaikocraft.entity.TOAIKOGroupFishEntity;
        import net.minecraft.client.renderer.IRenderTypeBuffer;
        import net.minecraft.client.renderer.RenderType;
        import net.minecraft.client.renderer.entity.EntityRendererManager;
        import net.minecraft.client.renderer.entity.MobRenderer;
        import net.minecraft.client.renderer.entity.model.EntityModel;
        import net.minecraft.util.ResourceLocation;
        import net.minecraft.util.math.MathHelper;
        import net.minecraft.util.math.vector.Vector3f;

        import javax.annotation.Nullable;

public class TOAIKOGroupFishRenderer extends MobRenderer<TOAIKOGroupFishEntity, EntityModel<TOAIKOGroupFishEntity>> {

    public TOAIKOGroupFishRenderer(EntityRendererManager p_i50961_1_) {
        super(p_i50961_1_, new FreshwaterAngelfishModel<>(), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(TOAIKOGroupFishEntity entity) {
        return entity.getVariantTextureLocation();
    }

    protected void setupRotations(TOAIKOGroupFishEntity fish, MatrixStack matrices, float xRot, float yRot, float zRot) {
        super.setupRotations(fish, matrices, xRot, yRot, zRot);
        float amp = fish.getFishType().getWiggleAmp();
        float freq = fish.getFishType().getWiggleFreq();
        float wiggle = amp * MathHelper.cos(xRot * freq);
        matrices.mulPose(Vector3f.YP.rotationDegrees(wiggle));
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

    @Override
    public void render(TOAIKOGroupFishEntity entity, float yaw, float ticks, MatrixStack matrices, IRenderTypeBuffer buffer, int i) {
        this.model = entity.getFishType().getModel();
        super.render(entity, yaw, ticks, matrices, buffer, i);
    }

}
