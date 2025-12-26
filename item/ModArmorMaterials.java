package mxa.modid.item;

import mxa.modid.MinecraftXAnimation;
import mxa.modid.block.ModBlocks;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> BLACK_JEWEL = registerArmorMaterial("black_jewel",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 9);
            map.put(ArmorItem.Type.LEGGINGS, 9);
            map.put(ArmorItem.Type.CHESTPLATE, 14);
            map.put(ArmorItem.Type.HELMET, 9);
            map.put(ArmorItem.Type.BODY, 19);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.BLACK_JEWEL)
        , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "black_jewel"))), 30.0F, 15.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> NETHERITE_INGOT = registerArmorMaterial("netherite_ingot",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 9);
            map.put(ArmorItem.Type.LEGGINGS, 12);
            map.put(ArmorItem.Type.CHESTPLATE, 14);
            map.put(ArmorItem.Type.HELMET, 9);
            map.put(ArmorItem.Type.BODY, 19);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_INGOT)
        , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "netherite_ingot"))), 16.0F, 4.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> NETHERITE_BLOCK = registerArmorMaterial("netherite_block",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 9);
            map.put(ArmorItem.Type.LEGGINGS, 12);
            map.put(ArmorItem.Type.CHESTPLATE, 14);
            map.put(ArmorItem.Type.HELMET, 9);
            map.put(ArmorItem.Type.BODY, 19);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.NETHERITE_BLOCK)
        , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "netherite_block"))), 16.0F, 4.0F));

    public static final RegistryEntry<ArmorMaterial> DARK_FEATHER = registerArmorMaterial("dark_feather",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA, () -> Ingredient.ofItems(ModItems.DARK_FEATHER)
        , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "dark_feather"))), 12.0F, 2.0F));

    public static final RegistryEntry<ArmorMaterial> GOLDEN_CRYSTAL = registerArmorMaterial("golden_crystal",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () ->
                    Ingredient.ofItems(ModItems.GOLDEN_CRYSTAL),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "golden_crystal"))), 15.0F, 2.0F));

    public static final RegistryEntry<ArmorMaterial> GOLD = registerArmorMaterial("gold_ingot",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 6);
            map.put(ArmorItem.Type.LEGGINGS, 9);
            map.put(ArmorItem.Type.CHESTPLATE, 11);
            map.put(ArmorItem.Type.HELMET, 6);
            map.put(ArmorItem.Type.BODY, 14);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () ->
                    Ingredient.ofItems(Items.GOLD_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "gold_ingot"))), 15.0F, 2.0F));

    public static final RegistryEntry<ArmorMaterial> GOLDEN_NUTS = registerArmorMaterial("golden_nuts",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () ->
                    Ingredient.ofItems(ModItems.GOLDEN_NUTS),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "golden_nuts"))), 15.0F, 2.0F));

    public static final RegistryEntry<ArmorMaterial> GOLDEN_DUST = registerArmorMaterial("golden_dust", () ->
            new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () ->
                    Ingredient.ofItems(ModItems.GOLDEN_DUST),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "golden_dust"))), 15.0F, 2.0F));

    public static final RegistryEntry<ArmorMaterial> GOLDEN_BLOCK = registerArmorMaterial("golden_block", () ->
            new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () ->
                    Ingredient.ofItems(ModBlocks.GOLDEN_BLOCK),
                    List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "golden_block"))), 19.0F, 5.0F));

    public static final RegistryEntry<ArmorMaterial> WHITE_GEM = registerArmorMaterial("white_gem", () ->
        new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 3);
            map.put(ArmorItem.Type.LEGGINGS, 6);
            map.put(ArmorItem.Type.CHESTPLATE, 8);
            map.put(ArmorItem.Type.HELMET, 3);
            map.put(ArmorItem.Type.BODY, 11);
        }), 40, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, () ->
                Ingredient.ofItems(ModItems.WHITE_GEM),
                List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "white_gem"))), 14.0F, 2.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> CARVED_PUMPKIN = registerArmorMaterial("carved_pumpkin",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
                map.put(ArmorItem.Type.BODY, 19);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.CARVED_PUMPKIN)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "carved_pumpkin"))), 20.0F, 8.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> REDSTONE = registerArmorMaterial("redstone",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
                map.put(ArmorItem.Type.BODY, 19);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.REDSTONE)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "redstone"))), 20.0F, 8.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> EGG = registerArmorMaterial("egg",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
                map.put(ArmorItem.Type.BODY, 19);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.EGG)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "egg"))), 20.0F, 8.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> DRAGON_EGG = registerArmorMaterial("dragon_egg",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
                map.put(ArmorItem.Type.BODY, 19);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.DRAGON_EGG)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "dragon_egg"))), 20.0F, 8.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> BEE_NEST = registerArmorMaterial("bee_nest",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
                map.put(ArmorItem.Type.BODY, 19);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.BEE_NEST)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "bee_nest"))), 20.0F, 8.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> POTATO = registerArmorMaterial("potato",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 14);
                map.put(ArmorItem.Type.HELMET, 9);
                map.put(ArmorItem.Type.BODY, 19);
            }), 60, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.POTATO)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "potato"))), 20.0F, 8.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> WHEAT = registerArmorMaterial("wheat",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 20);
                map.put(ArmorItem.Type.HELMET, 15);
                map.put(ArmorItem.Type.BODY, 300);
            }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.WHEAT)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "wheat"))), 16.0F, 4.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> EMERALD = registerArmorMaterial("emerald",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 20);
                map.put(ArmorItem.Type.HELMET, 15);
                map.put(ArmorItem.Type.BODY, 100);
            }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.EMERALD)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "emerald"))), 16.0F, 4.0F));

    public static final net.minecraft.registry.entry.RegistryEntry<ArmorMaterial> MAGMA_BLOCK = registerArmorMaterial("magma_block",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 40);
                map.put(ArmorItem.Type.LEGGINGS, 12);
                map.put(ArmorItem.Type.CHESTPLATE, 20);
                map.put(ArmorItem.Type.HELMET, 15);
                map.put(ArmorItem.Type.BODY, 19);
            }), 40, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(Items.MAGMA_BLOCK)
                    , List.of(new ArmorMaterial.Layer(Identifier.of(MinecraftXAnimation.MOD_ID, "magma_block"))), 16.0F, 4.0F));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(MinecraftXAnimation.MOD_ID, name), material.get());
    }
    }