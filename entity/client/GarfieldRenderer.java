package mxa.modid.entity.client;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.entity.custom.GarfieldEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GarfieldRenderer extends MobEntityRenderer<GarfieldEntity, GarfieldModel<GarfieldEntity>> {
    public GarfieldRenderer(EntityRendererFactory.Context context) {
        super(context, new GarfieldModel<>(context.getPart(GarfieldModel.GARFIELD)), 0.8F);
    }

    public Identifier getTexture(GarfieldEntity entity) {
        return Identifier.of(MinecraftXAnimation.MOD_ID, "textures/entity/cats/garfield.png");
    }

    public void render(GarfieldEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
