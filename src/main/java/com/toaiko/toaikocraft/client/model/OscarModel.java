package com.toaiko.toaikocraft.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.toaiko.toaikocraft.entities.OscarEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class OscarModel<T extends OscarEntity> extends EntityModel<T> {
    private final ModelRenderer Body;
    private final ModelRenderer Tail;
    private final ModelRenderer TailFin_r1;
    private final ModelRenderer bb_main;
    private final ModelRenderer RightPectoralFin_r1;
    private final ModelRenderer LeftPectoralFin_r1;

    public OscarModel() {
        texWidth = 16;
        texHeight = 16;

        Body = new ModelRenderer(this);
        Body.setPos(-0.5F, 23.3333F, 2.4167F);
        Body.texOffs(0, 0).addBox(-0.5F, -2.3333F, -2.4167F, 1.0F, 3.0F, 6.0F, 0.0F, false);
        Body.texOffs(8, 0).addBox(-0.5F, -1.8333F, -3.4167F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        Body.texOffs(0, 7).addBox(0.0F, 0.6667F, 0.5833F, 0.0F, 2.0F, 4.0F, 0.0F, false);
        Body.texOffs(0, 3).addBox(0.0F, -4.3333F, -1.4167F, 0.0F, 2.0F, 6.0F, 0.0F, false);
        Body.texOffs(0, 0).addBox(0.5F, 0.6667F, -2.4167F, 0.0F, 2.0F, 3.0F, 0.0F, false);
        Body.texOffs(0, 0).addBox(-0.5F, 0.6667F, -2.4167F, 0.0F, 2.0F, 3.0F, 0.0F, false);

        Tail = new ModelRenderer(this);
        Tail.setPos(-0.5F, 22.5F, 6.0F);
        Tail.texOffs(0, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

        TailFin_r1 = new ModelRenderer(this);
        TailFin_r1.setPos(-1.5F, 1.0F, 2.5F);
        Tail.addChild(TailFin_r1);
        setRotationAngle(TailFin_r1, 1.5708F, 0.0F, 0.0F);
        TailFin_r1.texOffs(8, 8).addBox(1.5F, -2.0F, -1.0F, 0.0F, 4.0F, 4.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setPos(0.0F, 24.0F, 0.0F);


        RightPectoralFin_r1 = new ModelRenderer(this);
        RightPectoralFin_r1.setPos(-1.0F, -1.0F, 2.0F);
        bb_main.addChild(RightPectoralFin_r1);
        setRotationAngle(RightPectoralFin_r1, 0.0F, -0.5236F, 0.0F);
        RightPectoralFin_r1.texOffs(0, 11).addBox(-0.5F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

        LeftPectoralFin_r1 = new ModelRenderer(this);
        LeftPectoralFin_r1.setPos(0.0F, -1.0F, 2.0F);
        bb_main.addChild(LeftPectoralFin_r1);
        setRotationAngle(LeftPectoralFin_r1, 0.0F, 0.5236F, 0.0F);
        LeftPectoralFin_r1.texOffs(0, 11).addBox(0.5F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
        float f = 1.0F;
        if (!entity.isInWater()) {
            f = 1.5F;
        }

        this.TailFin_r1.yRot = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);

        this.RightPectoralFin_r1.yRot = -f * 0.15F * MathHelper.sin(0.2F * ageInTicks) - 0.3f;
        this.LeftPectoralFin_r1.yRot  =  f * 0.15F * MathHelper.sin(0.2F * ageInTicks) + 0.3f;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        Tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
