package mxa.modid.entity.client;

import mxa.modid.MinecraftXAnimation;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer GOLEM_TOTEM = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "golem_totem"), "main");
    public static final EntityModelLayer SWORDSMAN_HEROBRINE = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "swordsman_herobrine"), "main");

    public static final EntityModelLayer SWORD_PROJECTILE = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "sword_projectile"), "main");
    public static final EntityModelLayer PICKAXE_PROJECTILE = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "pickaxe_projectile"), "main");
    public static final EntityModelLayer ENCHANTED_POTATO_PROJECTILE = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "enchanted_potato_projectile"), "main");

    public static final EntityModelLayer RED_STEEL_SPEAR_AXE_PROJECTILE = new EntityModelLayer(Identifier.of(MinecraftXAnimation.MOD_ID, "red_steel_spear_axe_projectile"), "main");
}