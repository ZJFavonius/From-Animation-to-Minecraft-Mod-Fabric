package mxa.modid.entity;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.entity.custom.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<GolemTotemEntity> GOLEM_TOTEM =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "golem_totem"),
                    FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GolemTotemEntity::new)
                            .dimensions(EntityDimensions.fixed(1.3F, 3.0F))
                            .build()));

    public static final EntityType<SwordsmanHerobrineEntity> SWORDSMAN_HEROBRINE =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "swordsman_herobrine"),
                    EntityType.Builder.create(SwordsmanHerobrineEntity::new, SpawnGroup.MONSTER)
                            .dimensions(0.6F, 1.8F)
                            .build()));

    public static final EntityType<GarfieldEntity> GARFIELD =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "garfield"),
                    EntityType.Builder.create(GarfieldEntity::new, SpawnGroup.CREATURE)
                            .dimensions(1.2F, 1.0F)
                            .eyeHeight(0.6F)
                            .build()));

    public static final EntityType<SwordProjectileEntity> SWORD_PROJECTILE =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "sword_projectile"),
                    EntityType.Builder.<SwordProjectileEntity>create(SwordProjectileEntity::new, SpawnGroup.MISC)
                            .dimensions(0.5F, 0.5F)
                            .build()));

    public static final EntityType<PickaxeProjectileEntity> PICKAXE_PROJECTILE =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "pickaxe_projectile"),
                    EntityType.Builder.<PickaxeProjectileEntity>create(PickaxeProjectileEntity::new, SpawnGroup.MISC)
                            .dimensions(0.5F, 0.5F)
                            .build()));

    public static final EntityType<EnchantedPotatoProjectileEntity> ENCHANTED_POTATO_PROJECTILE =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "enchanted_potato_projectile"),
                    EntityType.Builder.<EnchantedPotatoProjectileEntity>create(EnchantedPotatoProjectileEntity::new, SpawnGroup.MISC)
                            .dimensions(0.5F, 0.5F)
                            .build()));

    public static final EntityType<RedSteelSpearAxeProjectileEntity> RED_STEEL_SPEAR_AXE_PROJECTILE =
            (Registry.register(Registries.ENTITY_TYPE,
                    Identifier.of(MinecraftXAnimation.MOD_ID, "red_steel_spear_axe_projectile"),
                    EntityType.Builder.<RedSteelSpearAxeProjectileEntity>create(RedSteelSpearAxeProjectileEntity::new, SpawnGroup.MISC)
                            .dimensions(0.5F, 0.5F)
                            .build()));

    public static void registerModEntities() {
        MinecraftXAnimation.LOGGER.info("Registering Mod Entities for minecraft_x_animation");
    }
}
