package mxa.modid.entity.client;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.entity.custom.SwordsmanHerobrineEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SwordsmanHerobrineRenderer extends MobEntityRenderer<SwordsmanHerobrineEntity, SwordsmanHerobrineModel<SwordsmanHerobrineEntity>> {
    public SwordsmanHerobrineRenderer(EntityRendererFactory.Context context) {
        super(context, new SwordsmanHerobrineModel<>(context.getPart(SwordsmanHerobrineModel.SWORDSMAN_HEROBRINE)), 0.6F);
    }

    public Identifier getTexture(SwordsmanHerobrineEntity entity) {
        return Identifier.of(MinecraftXAnimation.MOD_ID, "textures/entity/swordsman/swordsman_herobrine.png");
    }

    public void render(SwordsmanHerobrineEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
