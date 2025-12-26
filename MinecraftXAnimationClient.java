package mxa.modid;

import mxa.modid.block.ModBlocks;
import mxa.modid.entity.ModEntities;
import mxa.modid.entity.client.*;
import mxa.modid.item.ModItems;
import mxa.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class MinecraftXAnimationClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(SwordsmanHerobrineModel.SWORDSMAN_HEROBRINE, SwordsmanHerobrineModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SWORDSMAN_HEROBRINE, SwordsmanHerobrineRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(GarfieldModel.GARFIELD, GarfieldModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GARFIELD, GarfieldRenderer::new);

        EntityRendererRegistry.register(ModEntities.GOLEM_TOTEM, GolemTotemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GOLEM_TOTEM, GolemTotemModel::getTexturedModelData);

        EntityRendererRegistry.register(mxa.modid.entity.ModEntities.SWORD_PROJECTILE, SwordProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SWORD_PROJECTILE, SwordProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(mxa.modid.entity.ModEntities.PICKAXE_PROJECTILE, PickaxeProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PICKAXE_PROJECTILE, PickaxeProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(mxa.modid.entity.ModEntities.ENCHANTED_POTATO_PROJECTILE, EnchantedPotatoProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ENCHANTED_POTATO_PROJECTILE, EnchantedPotatoProjectileModel::getTexturedModelData);

        EntityRendererRegistry.register(mxa.modid.entity.ModEntities.RED_STEEL_SPEAR_AXE_PROJECTILE, RedSteelSpearAxeProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RED_STEEL_SPEAR_AXE_PROJECTILE, RedSteelSpearAxeProjectileModel::getTexturedModelData);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());

    }
}