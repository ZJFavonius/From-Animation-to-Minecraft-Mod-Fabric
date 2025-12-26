package mxa.modid.entity.client;

import mxa.modid.entity.animation.ModAnimations;
import mxa.modid.entity.custom.GolemTotemEntity;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GolemTotemModel<T extends GolemTotemEntity> extends SinglePartEntityModel<T> {
    private final ModelPart golem_totem;
    private final ModelPart head;

    public GolemTotemModel(ModelPart root) {
        this.golem_totem = root.getChild("golem_totem");
        this.head = this.golem_totem.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData golem_totem = modelPartData.addChild("golem_totem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 16.0F, 0.0F));
        golem_totem.addChild("head", ModelPartBuilder.create().uv(0, 8).cuboid(-4.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -4.0F, 1.0F));
        golem_totem.addChild("top", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-8.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-4.0F, 0.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 0.0F, 1.0F));
        golem_totem.addChild("bot", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, 4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, 0.0F, 1.0F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.animateMovement(ModAnimations.bounce, limbAngle, limbDistance, 2.0F, 2.5F);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.stationary, animationProgress, 1.0F);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.stamp, animationProgress, 1.0F);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.golem_totem.render(matrices, vertices, light, overlay, color);
    }

    public ModelPart getPart() {
        return this.golem_totem;
    }
}