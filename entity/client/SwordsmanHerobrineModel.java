package mxa.modid.entity.client;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.entity.animation.ModAnimations;
import mxa.modid.entity.custom.SwordsmanHerobrineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SwordsmanHerobrineModel<T extends SwordsmanHerobrineEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer SWORDSMAN_HEROBRINE = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "swordsman_herobrine"), "main");

    private final ModelPart swordsmanherobrine;
    private final ModelPart Head;
    private final ModelPart Body;
    private final ModelPart Saya;
    private final ModelPart RightArm;
    private final ModelPart Katana;
    private final ModelPart LeftArm;
    private final ModelPart RightLeg;
    private final ModelPart LeftLeg;
    private float headYaw;
    private float headPitch;

    public SwordsmanHerobrineModel(ModelPart root) {
        this.swordsmanherobrine = root.getChild("swordsmanherobrine");
        this.Head = this.swordsmanherobrine.getChild("Head");
        this.Body = this.swordsmanherobrine.getChild("Body");
        this.Saya = this.Body.getChild("Saya");
        this.RightArm = this.swordsmanherobrine.getChild("RightArm");
        this.Katana = this.RightArm.getChild("Katana");
        this.LeftArm = this.swordsmanherobrine.getChild("LeftArm");
        this.RightLeg = this.swordsmanherobrine.getChild("RightLeg");
        this.LeftLeg = this.swordsmanherobrine.getChild("LeftLeg");
        this.headYaw = this.headYaw;
        this.headPitch = this.headPitch;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData swordsmanherobrine = modelPartData.addChild("swordsmanherobrine", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
        swordsmanherobrine.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
        ModelPartData Body = swordsmanherobrine.addChild("Body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));
        Body.addChild("Saya", ModelPartBuilder.create().uv(55, 32).cuboid(-1.0F, -2.0F, -6.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(54, 42).cuboid(-1.0F, -3.0F, -8.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)).uv(56, 33).cuboid(-1.0F, -2.0F, -9.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).uv(56, 33).cuboid(-1.0F, -2.0F, 13.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)).uv(54, 42).cuboid(-1.0F, -3.0F, -4.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)).uv(55, 32).cuboid(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(54, 42).cuboid(-1.0F, -3.0F, 0.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)).uv(55, 32).cuboid(-1.0F, -2.0F, 2.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(54, 42).cuboid(-1.0F, -3.0F, 4.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)).uv(55, 32).cuboid(-1.0F, -2.0F, 6.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(55, 43).cuboid(-1.0F, -3.0F, 12.0F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)).uv(55, 32).cuboid(-1.0F, -2.0F, 10.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(54, 42).cuboid(-1.0F, -3.0F, 8.0F, 1.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.85F, 12.0F, 1.0F));
        ModelPartData RightArm = swordsmanherobrine.addChild("RightArm", ModelPartBuilder.create().uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));
        ModelPartData Katana = RightArm.addChild("Katana", ModelPartBuilder.create().uv(50, 36).cuboid(0.0F, -1.4F, -12.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -13.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.175F, -13.675F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, 5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, 4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -7.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -8.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -9.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.075F, -10.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.1F, -11.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.125F, -12.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, 5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, 4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -7.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -8.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.05F, -9.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.1F, -10.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -11.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.25F, -12.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.15F, -12.8F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -9.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -8.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -7.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -11.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -10.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -12.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.6F, -13.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.6F, -14.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.2F, -14.6F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.375F, -15.3F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -7.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -8.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -12.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -11.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -10.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -9.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -14.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -13.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.775F, -15.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.475F, -15.625F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.55F, -15.85F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(51, 37).cuboid(0.0F, -1.775F, -15.0F, 0.0F, 1.0F, 0.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -11.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -10.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -9.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -8.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -7.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -6.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, -4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 0.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 1.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 2.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 5.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 4.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(50, 36).cuboid(0.0F, -1.4F, 3.0F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(40, 40).cuboid(0.025F, -2.0F, -6.0F, 0.0F, 1.0F, 12.0F, new Dilation(0.0F)).uv(44, 42).cuboid(0.025F, -2.0F, -16.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F)).uv(53, 54).cuboid(-2.0F, -2.0F, 6.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).uv(53, 54).cuboid(0.0F, -2.0F, 6.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)).uv(53, 55).cuboid(-1.0F, 0.0F, 6.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(53, 55).cuboid(-1.0F, -3.0F, 6.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)).uv(48, 37).cuboid(-1.0F, -2.0F, 7.0F, 2.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 9.0F, -9.0F));
        Katana.addChild("sageo_r1", ModelPartBuilder.create().uv(0, 20).mirrored().cuboid(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.375F, -1.55F, 12.0F, 0.0F, 0.0F, 1.2174F));
        Katana.addChild("sageo_r2", ModelPartBuilder.create().uv(0, 20).mirrored().cuboid(1.0F, -1.0F, 0.0F, 4.0F, 1.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.775F, -0.3F, 12.0F, 0.0F, 0.0F, 1.7541F));
        Katana.addChild("sageo_r3", ModelPartBuilder.create().uv(0, 20).cuboid(-3.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.8F, -0.3F, 12.0F, 0.0F, 0.0F, -1.7541F));
        Katana.addChild("sageo_r4", ModelPartBuilder.create().uv(0, 20).cuboid(-3.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.35F, -1.55F, 12.0F, 0.0F, 0.0F, -1.2174F));
        Katana.addChild("kashira_r1", ModelPartBuilder.create().uv(53, 54).cuboid(-1.0F, -2.0F, 4.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.025F, 8.0F, 0.0F, 0.0F, 0.0087F));
        Katana.addChild("sori_r1", ModelPartBuilder.create().uv(44, 42).cuboid(0.0F, -1.0F, -10.0F, 0.0F, 1.0F, 10.0F, new Dilation(0.0F)).uv(40, 40).cuboid(0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-0.025F, -2.0F, -6.0F, 0.0F, 0.0F, -3.1416F));
        swordsmanherobrine.addChild("LeftArm", ModelPartBuilder.create().uv(32, 48).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));
        swordsmanherobrine.addChild("RightLeg", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));
        swordsmanherobrine.addChild("LeftLeg", ModelPartBuilder.create().uv(16, 48).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, -12.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public void setAngles(SwordsmanHerobrineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.animateMovement(ModAnimations.SWORDSMAN_HEROBRINE_STALK, limbSwing, limbSwingAmount, 2.0F, 2.5F);
        this.updateAnimation(entity.idleAnimateState, ModAnimations.SWORDSMAN_HEROBRINE_IDLE, ageInTicks, 1.0F);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.SWORDSMAN_HEROBRINE_ONESWORD, ageInTicks, 1.0F);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        this.headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        this.headPitch =  MathHelper.clamp(headPitch, -25.0F, 45.0F);
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        swordsmanherobrine.render(matrices, vertices, light, overlay, color);
    }

    public ModelPart getPart() {
        return swordsmanherobrine;
    }
}
