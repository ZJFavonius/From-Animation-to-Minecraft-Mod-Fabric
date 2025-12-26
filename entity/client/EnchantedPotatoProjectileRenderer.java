package mxa.modid.entity.client;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.entity.custom.EnchantedPotatoProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class EnchantedPotatoProjectileRenderer extends EntityRenderer<EnchantedPotatoProjectileEntity> {
    protected EnchantedPotatoProjectileModel model;

    public EnchantedPotatoProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new EnchantedPotatoProjectileModel(ctx.getPart(EnchantedPotatoProjectileModel.ENCHANTED_POTATO_PROJECTILE));
    }

    public void render(EnchantedPotatoProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        if (!entity.isGrounded()) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw())));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.getRenderingRotation() * 5.0F));
            matrices.translate(0.0F, -1.0F, 0.0F);
        } else {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.groundedOffset.getY()));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.groundedOffset.getX()));
            matrices.translate(0.0F, -1.0F, 0.0F);
        }

        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, this.model.getLayer(Identifier.of("minecraft_x_animation", "textures/entity/enchanted_potato_projectile.png")), false, true);
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    public Identifier getTexture(EnchantedPotatoProjectileEntity entity) {
        return Identifier.of(MinecraftXAnimation.MOD_ID, "textures/entity/enchanted_potato_projectile.png");
    }
}