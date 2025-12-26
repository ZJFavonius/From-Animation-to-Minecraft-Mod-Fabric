package mxa.modid.entity.client;

import mxa.modid.entity.custom.GolemTotemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GolemTotemRenderer extends MobEntityRenderer<GolemTotemEntity, GolemTotemModel<GolemTotemEntity>> {
    private static final Identifier TEXTURE = Identifier.of("minecraft_x_animation", "textures/entity/golem_totem.png");

    public GolemTotemRenderer(EntityRendererFactory.Context context) {
        super(context, new GolemTotemModel<>(context.getPart(ModModelLayers.GOLEM_TOTEM)), 1.0F);
    }

    protected void scale(GolemTotemEntity entity, MatrixStack matrices, float amount) {
        matrices.scale(4.0F, 4.0F, 4.0F);
        super.scale(entity, matrices, amount);
    }

    public Identifier getTexture(GolemTotemEntity entity) {
        return TEXTURE;
    }

    public void render(GolemTotemEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}