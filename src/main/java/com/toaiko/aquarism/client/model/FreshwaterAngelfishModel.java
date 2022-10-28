package com.toaiko.aquarism.client.model;
// Made with Blockbench 4.4.3

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.toaiko.aquarism.entities.FreshwaterAngelfishEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class FreshwaterAngelfishModel<T extends FreshwaterAngelfishEntity> extends EntityModel<T> {
    private final ModelRenderer Body;
    private final ModelRenderer BackFin;
    private final ModelRenderer bb_main;
    private final ModelRenderer cube_r1;
    private final ModelRenderer RightPectoralFin_r1;
    private final ModelRenderer LeftPectoralFin_r1;
    private final ModelRenderer RightStreamerFin_r1;
    private final ModelRenderer LeftStreamerFin_r1;
    private final ModelRenderer TopFin_r1;
    private final ModelRenderer BottomFin_r1;
    private final ModelRenderer Body_r1;

    public FreshwaterAngelfishModel() {
        texWidth = 16;
        texHeight = 16;

        Body = new ModelRenderer(this);
        Body.setPos(0.0F, 24.0F, 0.0F);

        BackFin = new ModelRenderer(this);
        BackFin.setPos(0.0F, 24.0F, 0.0F);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setPos(0.0F, 0.0F, 0.0F);
        BackFin.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.7854F, 0.0F, 0.0F);
        cube_r1.texOffs(9, 7).addBox(-0.5F, -7.5F, -2.5F, 0.0F, 3.0F, 3.0F, 0.0F, false);

        bb_main = new ModelRenderer(this);
        bb_main.setPos(0.0F, 24.0F, 0.0F);


        RightPectoralFin_r1 = new ModelRenderer(this);
        RightPectoralFin_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(RightPectoralFin_r1);
        setRotationAngle(RightPectoralFin_r1, 0.0F, -0.5236F, 0.0F);
        RightPectoralFin_r1.texOffs(8, 12).addBox(-1.15F, -6.0F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, false);

        LeftPectoralFin_r1 = new ModelRenderer(this);
        LeftPectoralFin_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(LeftPectoralFin_r1);
        setRotationAngle(LeftPectoralFin_r1, 0.0F, 0.5236F, 0.0F);
        LeftPectoralFin_r1.texOffs(8, 12).addBox(0.25F, -6.0F, -0.5F, 0.0F, 2.0F, 2.0F, 0.0F, false);

        RightStreamerFin_r1 = new ModelRenderer(this);
        RightStreamerFin_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(RightStreamerFin_r1);
        setRotationAngle(RightStreamerFin_r1, 0.0F, 0.0F, 0.0873F);
        RightStreamerFin_r1.texOffs(4, 0).addBox(-1.25F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);

        LeftStreamerFin_r1 = new ModelRenderer(this);
        LeftStreamerFin_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(LeftStreamerFin_r1);
        setRotationAngle(LeftStreamerFin_r1, 0.0F, 0.0F, -0.0873F);
        LeftStreamerFin_r1.texOffs(4, 0).addBox(0.25F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 0.0F, false);

        TopFin_r1 = new ModelRenderer(this);
        TopFin_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(TopFin_r1);
        setRotationAngle(TopFin_r1, 1.0908F, 0.0F, 0.0F);
        TopFin_r1.texOffs(6, -5).addBox(-0.5F, -3.5F, 5.0F, 0.0F, 3.0F, 5.0F, 0.0F, false);

        BottomFin_r1 = new ModelRenderer(this);
        BottomFin_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(BottomFin_r1);
        setRotationAngle(BottomFin_r1, -1.0908F, 0.0F, 0.0F);
        BottomFin_r1.texOffs(6, 1).addBox(-0.5F, -4.5F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, false);

        Body_r1 = new ModelRenderer(this);
        Body_r1.setPos(0.0F, 0.0F, 0.0F);
        bb_main.addChild(Body_r1);
        setRotationAngle(Body_r1, -0.7854F, 0.0F, 0.0F);
        Body_r1.texOffs(0, 7).addBox(-1.0F, -5.0F, -5.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.5F;
        }

        this.BackFin.yRot = -f * 0.45F * MathHelper.sin(0.6F * ageInTicks);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        BackFin.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}