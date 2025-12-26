package mxa.modid.entity.client;

import mxa.modid.entity.custom.PickaxeProjectileEntity;
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

public class PickaxeProjectileModel extends EntityModel<PickaxeProjectileEntity> {
    public static final EntityModelLayer PICKAXE_PROJECTILE = new EntityModelLayer(Identifier.of("minecraft_x_animation", "pickaxe_projectile"), "main");
    private final ModelPart diamond_pickaxe;

    public PickaxeProjectileModel(ModelPart root) {
        this.diamond_pickaxe = root.getChild("diamond_pickaxe");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("diamond_pickaxe", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 0).cuboid(0.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-1.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-2.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-3.0F, -6.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 0).cuboid(2.0F, -5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 6).cuboid(1.0F, -5.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(7, 9).cuboid(0.0F, -5.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(0, 9).cuboid(-1.0F, -5.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(0, 9).cuboid(-2.0F, -5.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(6, 6).cuboid(-3.0F, -5.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(0, 0).cuboid(-4.0F, -5.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(-5.0F, -5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 7).cuboid(-6.0F, -5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(0, 0).cuboid(1.0F, -4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 0).cuboid(0.0F, -4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 0).cuboid(-1.0F, -4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(4, 0).cuboid(-2.0F, -4.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 9).cuboid(-3.0F, -4.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(0, 9).cuboid(-4.0F, -4.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(3, 14).cuboid(-5.0F, -4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(-6.0F, -4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 2).cuboid(-3.0F, -3.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(6, 6).cuboid(-4.0F, -3.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(0, 9).cuboid(-5.0F, -3.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(4, 0).cuboid(-6.0F, -3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(-2.0F, -2.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 7).cuboid(-3.0F, -2.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(-4.0F, -2.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(0, 9).cuboid(-5.0F, -2.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(6, 6).cuboid(-6.0F, -2.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(4, 0).cuboid(-7.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(-1.0F, -1.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(3, 14).cuboid(-2.0F, -1.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(-3.0F, -1.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(4, 0).cuboid(-5.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 9).cuboid(-6.0F, -1.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(4, 0).cuboid(-7.0F, -1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(0.0F, 0.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 7).cuboid(-1.0F, 0.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(-2.0F, 0.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(4, 0).cuboid(-5.0F, 0.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 9).cuboid(-6.0F, 0.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(4, 0).cuboid(-7.0F, 0.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(1.0F, 1.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(3, 14).cuboid(0.0F, 1.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(-1.0F, 1.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(4, 0).cuboid(-5.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(6, 6).cuboid(-6.0F, 1.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(4, 0).cuboid(-7.0F, 1.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(2.0F, 2.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 7).cuboid(1.0F, 2.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(0.0F, 2.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(4, 0).cuboid(-5.0F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(0, 6).cuboid(-6.0F, 2.0F, -8.1F, 1.0F, 1.0F, 1.2F, new Dilation(0.0F)).uv(4, 0).cuboid(-7.0F, 2.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(3.0F, 3.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(3, 14).cuboid(2.0F, 3.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(1.0F, 3.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(4, 0).cuboid(-6.0F, 3.0F, -8.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(12, 2).cuboid(4.0F, 4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 7).cuboid(3.0F, 4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(2.0F, 4.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 2).cuboid(5.0F, 5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(3, 14).cuboid(4.0F, 5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(3.0F, 5.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(5.0F, 6.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)).uv(12, 10).cuboid(4.0F, 6.0F, -7.8F, 1.0F, 1.0F, 0.6F, new Dilation(0.0F)), ModelTransform.of(7.5F, 16.0F, 1.25F, 1.5708F, 0.7854F, 1.5708F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    public void setAngles(PickaxeProjectileEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.diamond_pickaxe.render(matrices, vertices, light, light);
    }
}