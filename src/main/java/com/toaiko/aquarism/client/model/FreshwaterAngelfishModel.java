package com.toaiko.aquarism.client.model;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.toaiko.aquarism.entities.FreshwaterAngelfishEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class FreshwaterAngelfishModel<T extends FreshwaterAngelfishEntity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
    private final ModelRenderer Body;
    private final ModelRenderer BackFin;
    private final ModelRenderer bb_main;

    public FreshwaterAngelfishModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.BackFin = root.getChild("BackFin");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition BackFin = partdefinition.addOrReplaceChild("BackFin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition cube_r1 = BackFin.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(9, 7).addBox(-0.5F, -7.5F, -2.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition RightPectoralFin_r1 = bb_main.addOrReplaceChild("RightPectoralFin_r1", CubeListBuilder.create().texOffs(8, 12).addBox(-1.15F, -6.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

        PartDefinition LeftPectoralFin_r1 = bb_main.addOrReplaceChild("LeftPectoralFin_r1", CubeListBuilder.create().texOffs(8, 12).addBox(0.25F, -6.0F, -0.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

        PartDefinition RightStreamerFin_r1 = bb_main.addOrReplaceChild("RightStreamerFin_r1", CubeListBuilder.create().texOffs(4, 0).addBox(-1.25F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition LeftStreamerFin_r1 = bb_main.addOrReplaceChild("LeftStreamerFin_r1", CubeListBuilder.create().texOffs(4, 0).addBox(0.25F, -4.0F, -1.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition TopFin_r1 = bb_main.addOrReplaceChild("TopFin_r1", CubeListBuilder.create().texOffs(6, -5).addBox(-0.5F, -3.5F, 5.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0908F, 0.0F, 0.0F));

        PartDefinition BottomFin_r1 = bb_main.addOrReplaceChild("BottomFin_r1", CubeListBuilder.create().texOffs(6, 1).addBox(-0.5F, -4.5F, -4.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0908F, 0.0F, 0.0F));

        PartDefinition Body_r1 = bb_main.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(0, 7).addBox(-1.0F, -5.0F, -5.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        BackFin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}