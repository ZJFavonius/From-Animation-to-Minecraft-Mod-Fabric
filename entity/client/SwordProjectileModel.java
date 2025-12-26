package mxa.modid.entity.client;

import mxa.modid.entity.custom.SwordProjectileEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SwordProjectileModel extends EntityModel<SwordProjectileEntity> {
    public static final EntityModelLayer SWORD_PROJECTILE = new EntityModelLayer(Identifier.of("minecraft_x_animation", "sword_projectile"), "main");
    private final ModelPart diamond_sword;

    public SwordProjectileModel(ModelPart root) {
        this.diamond_sword = root.getChild("diamond_sword");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("diamond_sword",
                ModelPartBuilder
                        .create().uv(29, 13)
                        .cuboid(-6.0F, -8.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(29, 13)
                        .cuboid(-7.0F, -8.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(29, 13)
                        .cuboid(-8.0F, -8.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(29, 13)
                        .cuboid(-5.0F, -7.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(16, 2)
                        .cuboid(-6.0F, -7.0F, -7.9F, 1.0F, 1.0F, 0.8F,
                                new Dilation(0.0F)).uv(16, 12)
                        .cuboid(-7.0F, -7.0F, -7.9F, 1.0F, 1.0F, 0.8F,
                                new Dilation(0.0F)).uv(0, 22)
                        .cuboid(-8.0F, -7.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(29, 13)
                        .cuboid(-4.0F, -6.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(16, 4)
                        .cuboid(-5.0F, -6.0F, -7.9F, 1.0F, 1.0F, 0.8F,
                                new Dilation(0.0F)).uv(16, 6)
                        .cuboid(-6.0F, -6.0F, -7.9F, 1.0F, 1.0F, 0.8F,
                                new Dilation(0.0F)).uv(8, 16)
                        .cuboid(-7.0F, -6.0F, -7.9F, 1.0F, 1.0F, 0.8F,
                                new Dilation(0.0F)).uv(4, 22)
                        .cuboid(-8.0F, -6.0F, -7.7F, 1.0F, 1.0F, 0.4F,
                                new Dilation(0.0F)).uv(29, 13).cuboid(-3.0F, -5.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(16, 8).cuboid(-4.0F, -5.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(16, 10).cuboid(-5.0F, -5.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(12, 16).cuboid(-6.0F, -5.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(8, 22).cuboid(-7.0F, -5.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(29, 13).cuboid(-2.0F, -4.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(16, 12).cuboid(-3.0F, -4.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(16, 14).cuboid(-4.0F, -4.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(16, 16).cuboid(-5.0F, -4.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(12, 22).cuboid(-6.0F, -4.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(29, 13).cuboid(-1.0F, -3.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(16, 12).cuboid(-2.0F, -3.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(0, 18).cuboid(-3.0F, -3.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(4, 18).cuboid(-4.0F, -3.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(18, 22).cuboid(-5.0F, -3.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(4, 12).cuboid(5.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 11).cuboid(4.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(29, 13).cuboid(0.0F, -2.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(8, 18).cuboid(-1.0F, -2.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(12, 18).cuboid(-2.0F, -2.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(16, 18).cuboid(-3.0F, -2.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(22, 19).cuboid(-4.0F, -2.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(4, 12).cuboid(5.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 14).cuboid(4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 2).cuboid(3.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(29, 13).cuboid(1.0F, -1.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(0, 20).cuboid(0.0F, -1.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(20, 0).cuboid(-1.0F, -1.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(20, 2).cuboid(-2.0F, -1.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(22, 20).cuboid(-3.0F, -1.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(4, 4).cuboid(4.0F, 0.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 6).cuboid(3.0F, 0.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 6).cuboid(2.0F, 0.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(11, 18).cuboid(1.0F, 0.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(20, 4).cuboid(0.0F, 0.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(20, 6).cuboid(-1.0F, 0.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(22, 21).cuboid(-2.0F, 0.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(0, 8).cuboid(4.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(8, 0).cuboid(3.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(8, 2).cuboid(2.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 8).cuboid(1.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(8, 20).cuboid(0.0F, 1.0F, -7.9F, 1.0F, 1.0F, 0.8F, new Dilation(0.0F)).uv(22, 22).cuboid(-1.0F, 1.0F, -7.7F, 1.0F, 1.0F, 0.4F, new Dilation(0.0F)).uv(8, 4).cuboid(3.0F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(8, 6).cuboid(2.0F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(8, 8).cuboid(1.0F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 10).cuboid(0.0F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(20, 8).cuboid(4.0F, 3.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(20, 10).cuboid(3.0F, 3.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(4, 10).cuboid(2.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(8, 10).cuboid(1.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 12).cuboid(0.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(-1.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 20).cuboid(5.0F, 4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(20, 12).cuboid(4.0F, 4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(20, 14).cuboid(3.0F, 4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 2).cuboid(1.0F, 4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(0.0F, 4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 4).cuboid(-1.0F, 4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(-2.0F, 4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 26).cuboid(7.0F, 5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 26).cuboid(6.0F, 5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(2, 24).cuboid(5.0F, 5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(6, 26).cuboid(4.0F, 5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 2).cuboid(-1.0F, 5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(-2.0F, 5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 26).cuboid(7.0F, 6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 28).cuboid(6.0F, 6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(2, 30).cuboid(5.0F, 6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 30).cuboid(7.0F, 7.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(1, 30).cuboid(6.0F, 7.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(2, 30).cuboid(5.0F, 7.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, 16.2F, -2.0F, 1.5708F, 0.0F, 1.5708F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    public void setAngles(SwordProjectileEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.diamond_sword.render(matrices, vertices, light, overlay);
    }
}