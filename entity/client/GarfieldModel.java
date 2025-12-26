package mxa.modid.entity.client;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.entity.animation.ModAnimations;
import mxa.modid.entity.custom.GarfieldEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class GarfieldModel<T extends GarfieldEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer GARFIELD = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "garfield"), "main");

    private final ModelPart garfield;
    private final ModelPart belly;
    private final ModelPart head;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart backLegL;
    private final ModelPart backLegR;
    private final ModelPart frontLegL;
    private final ModelPart frontLegR;
    private float headYaw;
    private float headPitch;

    public GarfieldModel(ModelPart root) {
        this.garfield = root.getChild("garfield");
        this.belly = this.garfield.getChild("belly");
        this.head = this.garfield.getChild("head");
        this.tail1 = this.garfield.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.backLegL = this.garfield.getChild("backLegL");
        this.backLegR = this.garfield.getChild("backLegR");
        this.frontLegL = this.garfield.getChild("frontLegL");
        this.frontLegR = this.garfield.getChild("frontLegR");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("garfield", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 17.0F, 1.0F));

        ModelPartData belly = root.addChild("belly", ModelPartBuilder.create().uv(20, 0).cuboid(-2.0F, -8.0F, -3.0F, 4.0F, 16.0F, 6.0F, new Dilation(0.0F))
                .uv(20, 0).cuboid(-2.8F, -4.0F, -4.0F, 3.0F, 9.0F, 6.0F, new Dilation(0.0F))
                .uv(22, 2).cuboid(-3.65F, -3.0F, -3.775F, 3.0F, 7.0F, 5.0F, new Dilation(0.0F))
                .uv(20, 0).mirrored().cuboid(-0.2F, -4.0F, -4.0F, 3.0F, 9.0F, 6.0F, new Dilation(0.0F)).mirrored(false)
                .uv(22, 2).mirrored().cuboid(0.65F, -3.0F, -3.775F, 3.0F, 7.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        ModelPartData head = root.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(3, 0).cuboid(-1.5F, 1.4F, -3.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-2.925F, -1.4F, -2.3F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(-1.5F, -0.0156F, -4.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 10).cuboid(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(6, 10).cuboid(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(1, 1).mirrored().cuboid(-2.075F, -1.4F, -2.3F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -2.0F, -10.0F));

        ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(16, 2).mirrored().cuboid(0.2F, -0.4F, 0.4F, 4.0F, 0.1F, 0.15F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.9F, -0.7F, -0.075F, -0.4626F, -0.8227F, 0.5975F));

        ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(16, 2).mirrored().cuboid(0.2F, -0.4F, 0.4F, 4.0F, 0.1F, 0.15F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -0.7F, -0.075F, 0.0F, -0.9163F, 0.0F));

        ModelPartData cube_r3 = head.addChild("cube_r3", ModelPartBuilder.create().uv(16, 2).mirrored().cuboid(0.2F, -0.4F, 0.4F, 4.0F, 0.1F, 0.15F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(3.0F, -0.7F, -0.075F, 0.4626F, -0.8227F, -0.5975F));

        ModelPartData cube_r4 = head.addChild("cube_r4", ModelPartBuilder.create().uv(16, 2).cuboid(-4.2F, -0.4F, 0.4F, 4.0F, 0.1F, 0.15F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -0.7F, -0.075F, 0.4626F, 0.8227F, 0.5975F));

        ModelPartData cube_r5 = head.addChild("cube_r5", ModelPartBuilder.create().uv(16, 2).cuboid(-4.2F, -0.4F, 0.4F, 4.0F, 0.1F, 0.15F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -0.7F, -0.075F, 0.0F, 0.9163F, 0.0F));

        ModelPartData cube_r6 = head.addChild("cube_r6", ModelPartBuilder.create().uv(16, 2).cuboid(-4.2F, -0.4F, 0.4F, 4.0F, 0.1F, 0.15F, new Dilation(0.0F)), ModelTransform.of(-2.9F, -0.7F, -0.075F, -0.4626F, 0.8227F, -0.5975F));

        ModelPartData tail1 = root.addChild("tail1", ModelPartBuilder.create().uv(0, 15).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.0F, 7.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData tail2 = tail1.addChild("tail2", ModelPartBuilder.create().uv(4, 15).cuboid(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 8.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        ModelPartData backLegL = root.addChild("backLegL", ModelPartBuilder.create().uv(8, 13).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.1F, 1.0F, 6.0F));

        ModelPartData backLegR = root.addChild("backLegR", ModelPartBuilder.create().uv(8, 13).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.1F, 1.0F, 6.0F));

        ModelPartData frontLegL = root.addChild("frontLegL", ModelPartBuilder.create().uv(40, 0).cuboid(-1.0F, -0.2F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.2F, -3.0F, -5.0F));

        ModelPartData frontLegR = root.addChild("frontLegR", ModelPartBuilder.create().uv(40, 0).cuboid(-1.0F, -0.2F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.2F, -3.0F, -5.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        garfield.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return garfield;
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.animateMovement(ModAnimations.CAR_WALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.CAR_IDLE, ageInTicks, 1.0F);

    }

    private void setHeadAngles(float headYaw, float headPitch) {
        this.headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        this.headPitch =  MathHelper.clamp(headPitch, -25.0F, 45.0F);
    }
}
